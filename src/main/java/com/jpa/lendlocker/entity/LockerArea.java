package com.jpa.lendlocker.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class LockerArea {

    @Id @GeneratedValue
    @Column(name = "area_id")
    private Long id;

    // 지역명
    @Column(name = "area_name")
    private String name;

}
