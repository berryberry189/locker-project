package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.*;
import com.jpa.lendlocker.enums.LendStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class LendRequestDto {

    private Long userKey;
    private Long areaId;
    private Long lockerNo;
    private int hour;
    private int price;

    public Lend toEntity(User user, Locker locker){
        locker.setUseYn("Y");
        return Lend.builder()
                .user(user)
                .locker(locker)
                .hour(hour)
                .price(price)
                .status(LendStatus.LEND)
                .lendDate(LocalDateTime.now())
                .build();
    }

}
