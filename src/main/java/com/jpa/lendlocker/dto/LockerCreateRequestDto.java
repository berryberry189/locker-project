package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerArea;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.enums.LockerType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LockerCreateRequestDto {

    @ApiModelProperty(value = "구역 id", required = true, example = "2")
    private Long areaId;
    @ApiModelProperty(value = "보관함 번호", required = true, example = "1")
    private Long lockerNo;
    @ApiModelProperty(value = "보관함 유형", required = true, example = "SMALL")
    private LockerType type;
    @ApiModelProperty(value = "보관함 가격", required = true, example = "2000")
    private int price;
    @ApiModelProperty(value = "보관함 사용가능 여부", required = true, example = "Y")
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




