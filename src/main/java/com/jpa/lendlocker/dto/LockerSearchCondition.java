package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.enums.LockerType;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LockerSearchCondition {

    @ApiParam(value = "[검색 조건] 사물함 구역", example = "1")
    private Long areaId;

    @ApiParam(value = "[검색 조건] 사물함 번호", example = "1")
    private Long lockerNo;

    @ApiParam(value = "[검색 조건] 구역 명", example = "구역1")
    private String areaName;

    @ApiParam(value = "[검색 조건] 사물함 종류", example = "SMALL")
    private LockerType type;

    @ApiParam(value = "[검색 조건] 사용 여부", example = "Y")
    private String useYn;

}
