package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Horse;
import by.grsu.solomenskay.tables.HorseTable;

public class HorseDao extends AbstractDao<HorseTable, Horse> {

    public HorseDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<HorseTable> getTableClass() {
        return HorseTable.class;
    }
}
