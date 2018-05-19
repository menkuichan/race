package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Administrator;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class AdministratorDaoTest extends AbstractXmlDaoTest<Administrator> {

    private static final String TEST_XML_FOLDER = "target/test-data/admin";

    public AdministratorDaoTest() {
        super(new AdministratorDao(TEST_XML_FOLDER));
    }

    @Override
    protected Administrator generateEntity() {
        return new Administrator(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 22, UUID.randomUUID().toString());
    }
}