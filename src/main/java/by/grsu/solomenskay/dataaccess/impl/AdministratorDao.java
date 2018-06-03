package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Administrator;
import by.grsu.solomenskay.tables.AdministratorTable;
import org.springframework.stereotype.Component;

@Component
public class AdministratorDao extends AbstractDao<AdministratorTable, Administrator> {

    public AdministratorDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<AdministratorTable> getTableClass() {
        return AdministratorTable.class;
    }
}
