package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Horse;
import by.grsu.solomenskay.datamodel.HorseRun;
import by.grsu.solomenskay.datamodel.RunType;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class HorseRunDaoTest extends AbstractXmlDaoTest<HorseRun> {

    private static final String TEST_XML_FOLDER = "target/test-data/horse-run";

    public HorseRunDaoTest() {
        super(new HorseRunDao(TEST_XML_FOLDER));
    }

    @Override
    protected HorseRun generateEntity() {
        final Horse randomHorse = new Horse(UUID.randomUUID().toString(), 22, UUID.randomUUID().toString());
        return new HorseRun(12, randomHorse, RunType.FLAT);
    }
}