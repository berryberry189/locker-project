package com.jpa.lendlocker.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSearchCondition {

    @ApiParam(value = "[검색 조건] 사용자 ID", example = "userId0")
    private String userId;

    @ApiParam(value = "[검색 조건] 사용자 이름" , example = "회원")
    private String name;

    @ApiParam(value = "[검색 조건] 사용자 전화번호" , example ="010-1111-0")
    private String mobile;
}
