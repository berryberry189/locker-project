package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LendRequestDto {

    private Long userKey;
    private Long areaId;
    private Long lockerNo;
    private int hour;
    private int price;
    private LendStatus status;
    private String useYn;

    public LendRequestDto(Lend lend){
        this.userKey = lend.getUser().getId();
        this.areaId = lend.getLocker().getLockerId().getAreaId();
        this.lockerNo = lend.getLocker().getLockerId().getLockerNo();
        this.hour = lend.getHour();
        this.price = lend.getPrice();
        this.status = lend.getStatus();
        this.useYn = lend.getLocker().getUseYn();
    }

    public Lend toEntity() {

        return Lend.builder()
                .hour(hour)
                .price(price)
                .status(status)
                .build();

    }


}
