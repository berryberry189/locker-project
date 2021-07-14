package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserCreateRequestDto {

    private String userId;
    private String name;
    private String mobile;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .name(name)
                .mobile(mobile)
                .build();
    }

}
