package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Bookmaker;
import by.grsu.solomenskay.datamodel.Client;
import by.grsu.solomenskay.tables.BookmakerTable;
import by.grsu.solomenskay.tables.ClientTable;

public class ClientDao extends AbstractDao<ClientTable, Client> {

    public ClientDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<ClientTable> getTableClass() {
        return ClientTable.class;
    }

    @Override
    public Client update(Client entity) {
        // get existing data
        final ClientTable table = deserializeFromXml();
        // find by ID
        for (final Client row : table.getRows()) {
            if (row.getId().equals(entity.getId())) {
                // found!!!
                // copy data
                row.setTelephoneNumber(entity.getTelephoneNumber());
                row.setAge(entity.getAge());
                row.setName(entity.getName());
                row.setSurname(entity.getSurname());
                row.seteMail(entity.geteMail());
            }
        }
        // save updated table
        serializeToXml(table);
        return entity;
    }
}
