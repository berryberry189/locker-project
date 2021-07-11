package com.jpa.lendlocker.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@IdClass(LockerId.class)
public class Locker {

    @Id
    @ManyToOne
    @JoinColumn(name = "area_id")
    private LockerArea area;

    @Id
    @Column(name = "locker_no")
    private Long lockerNo;

    @Column(name = "locker_type")
    private LockerType type;

    @Column(name = "locker_price")
    private int price;

    private String useYn;
}
