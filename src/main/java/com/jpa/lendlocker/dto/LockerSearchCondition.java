package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.enums.LockerType;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LockerSearchCondition {

    @ApiParam(value = "[검색 조건] 사물함 구역")
    private Long areaId;

    @ApiParam(value = "[검색 조건] 사물함 번호")
    private Long lockerNo;

    @ApiParam(value = "[검색 조건] 사물함 종류")
    private LockerType type;

    @ApiParam(value = "[검색 조건] 사용 여부")
    private String useYn;

}
