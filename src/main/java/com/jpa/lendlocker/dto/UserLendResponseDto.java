package com.jpa.lendlocker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpa.lendlocker.enums.LendStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter @Setter
public class UserLendResponseDto {

    private Long areaId;
    private String areaName;
    private Long lockerNo;
    private int hour;
    private int price;
    private LendStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime lendDate;
}
