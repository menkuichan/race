package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Client;
import by.grsu.solomenskay.tables.ClientTable;

public class ClientDao extends AbstractDao<ClientTable, Client> {

    public ClientDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<ClientTable> getTableClass() {
        return ClientTable.class;
    }
}
