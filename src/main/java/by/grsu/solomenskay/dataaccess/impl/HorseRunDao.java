package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.HorseRun;
import by.grsu.solomenskay.tables.BookmakerTable;
import by.grsu.solomenskay.tables.HorseRunTable;

public class HorseRunDao extends AbstractDao<HorseRunTable, HorseRun> {

    public HorseRunDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<HorseRunTable> getTableClass() {
        return HorseRunTable.class;
    }
}
