package com.jpa.lendlocker.entity;

import java.io.Serializable;
import java.util.Objects;

public class LockerId implements Serializable {

    private Long area;
    private Long lockerNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LockerId lockerId = (LockerId) o;
        return Objects.equals(area, lockerId.area) &&
                Objects.equals(lockerNo, lockerId.lockerNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, lockerNo);
    }
}
