package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.dataaccess.IXmlDao;
import by.grsu.solomenskay.datamodel.AbstractModel;
import by.grsu.solomenskay.tables.AbstractTable;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractDao<T extends AbstractTable<E>, E extends AbstractModel> implements IXmlDao<E> {

    private static final Logger log = LoggerFactory.getLogger(AbstractDao.class);

    private  final XStream xStream;
    private final String rootFolderPath;


    public AbstractDao() {
        this("target/data/" + UUID.randomUUID().toString() + ".xml");
    }

    public AbstractDao(final String rootFolderPath) {
        super();
        this.rootFolderPath = rootFolderPath;
        final File rootFolder = new File(rootFolderPath);
        if (!rootFolder.exists()) {
            rootFolder.mkdirs();
        }
        xStream = new XStream();
        xStream.processAnnotations(new Class[]{getTableClass()});

        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypesByRegExp(new String[]{"by.grsu.solomenskay.tables.*", "by.grsu.solomenskay.datamodel.*"});
    }

    /**
     * Reads file from FS and makes deserialization Xml->Java.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected T deserializeFromXml() {
        final String xml = readFromFile();
        if (StringUtils.isBlank(xml)) {
            try {
                return getTableClass().newInstance();
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (T) xStream.fromXML(xml);
    }

    /**
     * Makes serialization Java->Xml and saves to FS.
     *
     * @param table
     * @return
     */
    protected void serializeToXml(final T table) {
        final String xml = xStream.toXML(table);
        writeToFile(xml);
    }

    /**
     * Writes file to the local FS. Uses
     * by.grsu.pe.dataaccess.AbstractDao.getTableClass() to resolve filename.
     *
     * @param xml data to be written in file
     */
    private void writeToFile(final String xml) {
        try {
            log.debug("Writing to file {}", xml);
            final File file = new File(getFileName());
            if (!file.exists()) {
                file.createNewFile();
            }
            IOUtils.write(xml, new FileOutputStream(file));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads file from the local FS. Uses
     * by.grsu.pe.dataaccess.AbstractDao.getTableClass() to resolve filename.
     *
     * @return XML data as String
     */
    private String readFromFile() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            log.debug("Reading from file {}", getFileName());
            IOUtils.copy(new FileInputStream(getFileName()), output);
        } catch (final FileNotFoundException e) {
            return null;
        } catch (final IOException e) {
            throw new IllegalStateException(e);
        }
        return new String(output.toByteArray());
    }

    private String getFileName() {
        return new File(getRootFolderPath(), getTableClass().getSimpleName() + ".xml").getAbsolutePath();
    }

    public String getRootFolderPath() {
        return rootFolderPath;
    }

    /**
     * Will be used as ID generator (enough for training project).
     *
     * @return
     */
    protected Long getNextId() {
        return System.nanoTime();
    }

    protected abstract Class<T> getTableClass();

    @Override
    public E saveNew(E entity) {
        log.info("Saving entity with id={}", entity.getId());
        // set ID
        entity.setId(getNextId());
        // get existing data
        final T table = deserializeFromXml();
        // add new row
        table.getRows().add(entity);
        // save data
        serializeToXml(table);
        return entity;
    }

    @Override
    public E update(E entity) {
        log.info("Updating entity with id={}", entity.getId());
        final T table = deserializeFromXml();
        table.getRows()
                .stream()
                .filter(row -> row.getId().equals(entity.getId()))
                .findAny()
                .map(row -> table.getRows().indexOf(row))
                .ifPresent(index -> {
                    table.getRows().set(index, entity);
                    serializeToXml(table);
                });
        return entity;
    }

    @Override
    public E get(Long id) {
        log.info("Reading entity with id={}", id);
        return Optional.of(deserializeFromXml())
                .flatMap(table -> table.getRows()
                        .stream()
                        .filter(row -> row.getId().equals(id))
                        .findAny())
                .orElse(null);
    }

    @Override
    public List<E> getAll() {
        final T table = deserializeFromXml();
        return table.getRows();
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting entity with id {}", id);
        final T table = deserializeFromXml();
        table.getRows()
                .stream()
                .filter(row -> row.getId().equals(id))
                .findAny()
                .ifPresent(row -> {
                    table.getRows().remove(row);
                    serializeToXml(table);
                });
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all entities({})", this.getClass().getSimpleName());
        final T table = deserializeFromXml();
        table.getRows().clear();
        serializeToXml(table);
    }
}
