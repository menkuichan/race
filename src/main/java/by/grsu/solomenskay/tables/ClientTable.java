package by.grsu.solomenskay.tables;

import by.grsu.solomenskay.datamodel.Client;

import java.util.ArrayList;
import java.util.List;


public class ClientTable extends AbstractTable<Client> {
    private List<Client> rows;
    @Override
    public List<Client> getRows() {
        if (rows == null) {
            rows = new ArrayList<Client>();
        }
        return rows;
    }

    @Override
    public void setRows(List<Client> rows) {
        this.rows = rows;
    }
}
