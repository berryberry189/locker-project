package com.jpa.lendlocker.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class UserResponseDto {

    private Long userKey;
    private String userId;
    private String name;
    private String mobile;
    // 사용자별 라커 갯수
    private Long lockerNum;
    private List<UserLendResponseDto> lends;
}
