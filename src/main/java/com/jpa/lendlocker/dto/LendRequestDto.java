package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.*;
import com.jpa.lendlocker.enums.LendStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class LendRequestDto {

    @ApiModelProperty(value = "유저키", required = true, example = "1")
    private Long userKey;
    @ApiModelProperty(value = "구역 id", required = true, example = "1")
    private Long areaId;
    @ApiModelProperty(value = "락커 번호", required = true, example = "1")
    private Long lockerNo;
    @ApiModelProperty(value = "시간", required = true, example = "2")
    private int hour;
    @ApiModelProperty(value = "가격", required = true, example = "4000")
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
