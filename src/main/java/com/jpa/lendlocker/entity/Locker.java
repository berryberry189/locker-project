package com.jpa.lendlocker.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Locker {

    @MapsId("areaId")
    @ManyToOne
    @JoinColumn(name = "area_id")
    private LockerArea area;

    @EmbeddedId
    private LockerId lockerNo;

    @Column(name = "locker_type")
    private LockerType type;

    @Column(name = "locker_price")
    private int price;

    private String useYn;
}
