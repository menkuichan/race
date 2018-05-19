package by.grsu.solomenskay.tables;

import by.grsu.solomenskay.datamodel.Administrator;

import java.util.ArrayList;
import java.util.List;

public class AdministratorTable extends AbstractTable<Administrator> {
    private List<Administrator> rows;

    @Override
    public List<Administrator> getRows() {
        if (rows == null) {
            rows = new ArrayList<>();
        }
        return rows;
    }

    @Override
    public void setRows(List<Administrator> rows) {
        this.rows = rows;
    }
}
