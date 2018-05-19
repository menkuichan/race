package by.grsu.solomenskay.datamodel;

import java.io.Serializable;

public abstract class AbstractModel implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
