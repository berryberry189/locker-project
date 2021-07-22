package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserCreateRequestDto {

    @ApiModelProperty(value = "사용자 id", required = true, example = "userId100")
    private String userId;
    @ApiModelProperty(value = "사용자 이름", required = true, example = "회원100")
    private String name;
    @ApiModelProperty(value = "사용자 전화번호", required = true, example = "010-1111-1111")
    private String mobile;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .name(name)
                .mobile(mobile)
                .build();
    }

}
