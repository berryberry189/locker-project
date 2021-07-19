package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserResponseDto {

    private Long userKey;
    private String userId;
    private String name;
    private String mobile;

    public UserResponseDto(User user) {
        this.userKey = user.getUserKey();
        this.userId = user.getUserId();
        this.name = user.getName();
        this.mobile = user.getMobile();
    }
}
