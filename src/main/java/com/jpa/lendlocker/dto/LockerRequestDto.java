package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.entity.LockerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LockerRequestDto {

    private Long areaId;
    private Long lockerNo;
    private LockerType type;
    private int price;
    private String useYn;

    public LockerRequestDto(Locker locker){
        this.areaId = locker.getArea().getId();
        this.lockerNo = locker.getLockerId().getLockerNo();
        this.type = locker.getType();
        this.price = locker.getPrice();
        this.useYn = locker.getUseYn();
    }

}
