package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LockerUpdateRequestDto {
    private LockerType type;
    private int price;
    private String useYn;

    public Locker toEntity(){

        return Locker.builder()
                .type(type)
                .price(price)
                .useYn(useYn)
                .build();
    }
}
