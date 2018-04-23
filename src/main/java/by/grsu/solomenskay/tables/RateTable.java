package by.grsu.solomenskay.tables;

import by.grsu.solomenskay.datamodel.Rate;

import java.util.ArrayList;
import java.util.List;

public class RateTable extends AbstractTable<Rate> {
    private List<Rate> rows;
    @Override
    public List<Rate> getRows() {
        if (rows == null) {
            rows = new ArrayList<Rate>();
        }
        return rows;
    }

    @Override
    public void setRows(List<Rate> rows) {
        this.rows = rows;
    }
}
