package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerArea;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.enums.LockerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LockerCreateRequestDto {

    private Long areaId;
    private Long lockerNo;
    private LockerType type;
    private int price;
    private String useYn;

    public Locker toEntity(){
        LockerArea area = new LockerArea();
        area.setId(areaId);

        return Locker.builder()
                .area(area)
                .lockerId(new LockerId(areaId, lockerNo))
                .type(type)
                .price(price)
                .useYn(useYn)
                .build();
    }
}




