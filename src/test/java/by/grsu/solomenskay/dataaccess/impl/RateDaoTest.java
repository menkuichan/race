package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Client;
import by.grsu.solomenskay.datamodel.Currency;
import by.grsu.solomenskay.datamodel.Horse;
import by.grsu.solomenskay.datamodel.Rate;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class RateDaoTest extends AbstractXmlDaoTest<Rate> {

    private static final String TEST_XML_FOLDER = "target/test-data/rate";

    public RateDaoTest() {
        super(new RateDao(TEST_XML_FOLDER));
    }

    @Override
    protected Rate generateEntity() {
        final Horse randomHorse = new Horse(UUID.randomUUID().toString(), 22, UUID.randomUUID().toString());
        final Client randomClient = new Client(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 22, UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
        return new Rate(100, randomHorse, Currency.DOLLARS, randomClient);
    }
}