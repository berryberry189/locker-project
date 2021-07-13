package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserRequestDto {

    private String userId;
    private String name;
    private String mobile;

    public UserRequestDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.mobile = user.getMobile();
    }

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .name(name)
                .mobile(mobile)
                .build();
    }

}
