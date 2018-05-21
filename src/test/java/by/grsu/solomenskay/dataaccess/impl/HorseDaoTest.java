package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Horse;
import by.grsu.solomenskay.datamodel.Horse;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class HorseDaoTest extends AbstractXmlDaoTest<Horse> {

    private static final String TEST_XML_FOLDER = "target/test-data/horse";

    public HorseDaoTest() {
        super(new HorseDao(TEST_XML_FOLDER));
    }

    @Override
    protected Horse generateEntity() {
        return new Horse(UUID.randomUUID().toString(), 22, UUID.randomUUID().toString());
    }
}