package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserUpdateRequestDto {

    @ApiModelProperty(value = "사용자 이름",  example = "회원100")
    private String name;
    @ApiModelProperty(value = "사용자 전화번호", example = "010-1111-1111")
    private String mobile;

    public User toEntity(){
        return User.builder()
                .name(name)
                .mobile(mobile)
                .build();
    }
}
