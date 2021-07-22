package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.enums.LockerType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LockerUpdateRequestDto {

    @ApiModelProperty(value = "보관함 유형", example = "SMALL")
    private LockerType type;
    @ApiModelProperty(value = "보관함 가격", example = "2000")
    private int price;
    @ApiModelProperty(value = "보관함 사용가능 여부", example = "Y")
    private String useYn;

    public Locker toEntity(){

        return Locker.builder()
                .type(type)
                .price(price)
                .useYn(useYn)
                .build();
    }
}
