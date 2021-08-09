package com.jpa.lendlocker.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class LockerArea {

    @Id @GeneratedValue
    @Column(name = "area_id")
    private Long id;

    // 지역명
    @Column(name = "area_name")
    private String name;

    @Builder
    public LockerArea(String name){
        this.name = name;
    }

}
