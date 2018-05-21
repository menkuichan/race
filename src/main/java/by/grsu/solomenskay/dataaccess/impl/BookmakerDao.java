package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Bookmaker;
import by.grsu.solomenskay.tables.BookmakerTable;

public class BookmakerDao extends AbstractDao<BookmakerTable, Bookmaker> {

    public BookmakerDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<BookmakerTable> getTableClass() {
        return BookmakerTable.class;
    }
}
