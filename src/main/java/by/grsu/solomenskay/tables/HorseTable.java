package by.grsu.solomenskay.tables;

import by.grsu.solomenskay.datamodel.Horse;

import java.util.ArrayList;
import java.util.List;

public class HorseTable extends AbstractTable<Horse> {
    private List<Horse> rows;

    @Override
    public List<Horse> getRows() {
        if (rows == null) {
            rows = new ArrayList<>();
        }
        return rows;
    }

    @Override
    public void setRows(List<Horse> rows) {
        this.rows = rows;
    }
}
