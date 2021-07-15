package com.jpa.lendlocker.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Getter
public class LockerId implements Serializable {

    private Long areaId;

    @Column(name = "locker_no")
    private Long lockerNo;

    public LockerId() { }

    public LockerId(Long areaId, Long lockerNo) {
        this.areaId = areaId;
        this.lockerNo = lockerNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LockerId lockerId = (LockerId) o;
        return Objects.equals(areaId, lockerId.areaId) &&
                Objects.equals(lockerNo, lockerId.lockerNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, lockerNo);
    }
}
