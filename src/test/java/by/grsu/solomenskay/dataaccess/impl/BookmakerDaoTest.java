package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Administrator;
import by.grsu.solomenskay.datamodel.Bookmaker;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class BookmakerDaoTest extends AbstractXmlDaoTest<Bookmaker> {

    private static final String TEST_XML_FOLDER = "target/test-data/bookmaker";

    public BookmakerDaoTest() {
        super(new BookmakerDao(TEST_XML_FOLDER));
    }

    @Override
    protected Bookmaker generateEntity() {
        return new Bookmaker(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 22, 10, UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }
}