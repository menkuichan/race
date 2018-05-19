package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Bookmaker;
import by.grsu.solomenskay.datamodel.Client;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class ClientDaoTest extends AbstractXmlDaoTest<Client> {

    private static final String TEST_XML_FOLDER = "target/test-data/client";

    public ClientDaoTest() {
        super(new ClientDao(TEST_XML_FOLDER));
    }

    @Override
    protected Client generateEntity() {
        return new Client(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 22, UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }
}