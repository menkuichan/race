package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Rate;
import by.grsu.solomenskay.tables.RateTable;

public class RateDao extends AbstractDao<RateTable, Rate> {

    public RateDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<RateTable> getTableClass() {
        return RateTable.class;
    }
}
