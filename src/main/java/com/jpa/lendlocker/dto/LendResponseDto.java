package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.Lend;
import com.jpa.lendlocker.enums.LendStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class LendResponseDto {

    private String userId;
    private Long areaId;
    private String areaName;
    private Long lockerNo;
    private int hour;
    private int price;
    private LendStatus status;
    private LocalDateTime lendDate;

    public LendResponseDto(Lend lend){
        this.userId = lend.getUser().getUserId();
        this.areaId = lend.getLocker().getLockerId().getAreaId();
        this.areaName = lend.getLocker().getArea().getName();
        this.lockerNo = lend.getLocker().getLockerId().getLockerNo();
        this.hour = lend.getHour();
        this.price = lend.getPrice();
        this.status = lend.getStatus();
        this.lendDate = lend.getLendDate();
    }

}
