package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Bookmaker;
import by.grsu.solomenskay.tables.AdministratorTable;
import by.grsu.solomenskay.tables.BookmakerTable;

public class BookmakerDao extends AbstractDao<BookmakerTable, Bookmaker> {

    public BookmakerDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<BookmakerTable> getTableClass() {
        return BookmakerTable.class;
    }

    @Override
    public Bookmaker update(Bookmaker entity) {
        // get existing data
        final BookmakerTable table = deserializeFromXml();
        // find by ID
        for (final Bookmaker row : table.getRows()) {
            if (row.getId().equals(entity.getId())) {
                // found!!!
                // copy data
                row.setWorkNumber(entity.getWorkNumber());
                row.setAge(entity.getAge());
                row.setName(entity.getName());
                row.setSurname(entity.getSurname());
                row.setWorkAddress(entity.getWorkAddress());
                row.setWorkExperience(entity.getWorkExperience());
            }
        }
        // save updated table
        serializeToXml(table);
        return entity;
    }
}
