package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LockerResponseDto {

    private Long areaId;
    private String areaName;
    private Long lockerNo;
    private LockerType type;
    private int price;
    private String useYn;

    public LockerResponseDto(Locker locker){
        this.areaId = locker.getArea().getId();
        this.areaName = locker.getArea().getName();
        this.lockerNo = locker.getLockerId().getLockerNo();
        this.type = locker.getType();
        this.price = locker.getPrice();
        this.useYn = locker.getUseYn();
    }

}
