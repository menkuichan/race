package by.grsu.solomenskay.tables;

import by.grsu.solomenskay.datamodel.Bookmaker;

import java.util.ArrayList;
import java.util.List;

public class BookmakerTable extends AbstractTable<Bookmaker> {
    private List<Bookmaker> rows;
    @Override
    public List<Bookmaker> getRows() {
        if (rows == null) {
            rows = new ArrayList<Bookmaker>();
        }
        return rows;
    }

    @Override
    public void setRows(List<Bookmaker> rows) {
        this.rows = rows;
    }

}
