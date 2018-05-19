package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Administrator;
import by.grsu.solomenskay.tables.AdministratorTable;

import java.util.List;
import java.util.Optional;

public class AdministratorDao extends AbstractDao<AdministratorTable, Administrator> {

    public AdministratorDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<AdministratorTable> getTableClass() {
        return AdministratorTable.class;
    }

    @Override
    public Administrator saveNew(Administrator entity) {
        // set ID
        entity.setId(getNextId());
        // get existing data
        final AdministratorTable table = deserializeFromXml();
        // add new row
        table.getRows().add(entity);
        // save data
        serializeToXml(table);
        return entity;
    }

    @Override
    public Administrator update(Administrator entity) {
        // get existing data
        final AdministratorTable table = deserializeFromXml();
        // find by ID
        for (final Administrator row : table.getRows()) {
            if (row.getId().equals(entity.getId())) {
                // found!!!
                // copy data
                row.setWorkNumber(entity.getWorkNumber());
                row.setAge(entity.getAge());
                row.setName(entity.getName());
                row.setSurname(entity.getSurname());
            }
        }
        // save updated table
        serializeToXml(table);
        return entity;
    }

    @Override
    public Administrator get(Long id) {
        return Optional.of(deserializeFromXml())
                .flatMap(table -> table.getRows()
                        .stream()
                        .filter(row -> row.getId().equals(id))
                        .findAny())
                        .orElse(null);
    }

    @Override
    public List<Administrator> getAll() {
        final AdministratorTable table = deserializeFromXml();
        return table.getRows()  ;
    }

    @Override
    public void delete(Long id) {
        final AdministratorTable table = deserializeFromXml();
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
        final AdministratorTable emptyTable = new AdministratorTable();
        serializeToXml(emptyTable);
    }
}
