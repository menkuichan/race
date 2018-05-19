package by.grsu.solomenskay.tables;

import by.grsu.solomenskay.datamodel.HorseRun;

import java.util.ArrayList;
import java.util.List;

public class HorseRunTable extends AbstractTable<HorseRun> {
    private List<HorseRun> rows;

    @Override
    public List<HorseRun> getRows() {
        if (rows == null) {
            rows = new ArrayList<>();
        }
        return rows;
    }

    @Override
    public void setRows(List<HorseRun> rows) {
        this.rows = rows;
    }
}
