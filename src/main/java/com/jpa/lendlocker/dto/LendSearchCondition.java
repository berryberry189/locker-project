package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.enums.LendStatus;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter @Setter
public class LendSearchCondition {

    @ApiParam(value = "[검색 조건] 사용자 ID", example = "userId0")
    private String userId;

    @ApiParam(value = "[검색 조건] 구역 명", example = "구역1")
    private String areaName;

    @ApiParam(value = "[검색 조건] 대여 상태", example = "LEND")
    private LendStatus status;

    @ApiParam(value = "[검색 조건] 기간 검색 시작 날짜")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;

    @ApiParam(value = "[검색 조건] 기간 검색 종료 날짜")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTime;

}
