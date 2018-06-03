package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.dataaccess.IXmlDao;
import by.grsu.solomenskay.datamodel.AbstractModel;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractXmlDaoTest<T extends AbstractModel> {

    private final IXmlDao<T> dao;

    public AbstractXmlDaoTest(IXmlDao<T> dao) {
        this.dao = dao;
    }

    @After
    public void after() {
//        dao.deleteAll();
    }

    protected abstract T generateEntity();

    @Test
    public void saveNewTest() {
        final T saved = dao.saveNew(generateEntity());
        final T found = dao.get(saved.getId());
        assertEquals(saved, found);
    }

    @Test
    public void updateTest() {
        final T originSavedEntity = dao.saveNew(generateEntity());
        final T newEntity = generateEntity();
        newEntity.setId(originSavedEntity.getId());
        final T updatedEntity = dao.update(newEntity);
        final T found = dao.get(updatedEntity.getId());
        assertNotSame(originSavedEntity, found);
    }

    @Test
    public void getTest() {
        final T saved = dao.saveNew(generateEntity());
        final T found = dao.get(saved.getId());
        assertEquals(saved, found);
    }

    @Test
    public void getAllTest() {
        final T saved = dao.saveNew(generateEntity());
        final List<T> found = dao.getAll();
        assertTrue(found.contains(saved));
    }

    @Test
    public void deleteTest() {
        final T saved = dao.saveNew(generateEntity());
        dao.delete(saved.getId());
        final T found = dao.get(saved.getId());
        assertNull(found);
    }

    @Test
    public void deleteAllTest() {
        dao.saveNew(generateEntity());
        dao.saveNew(generateEntity());
        dao.saveNew(generateEntity());

        dao.deleteAll();
        assertTrue(dao.getAll().isEmpty());
    }
}