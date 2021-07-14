package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;

public class UserUpdateRequestDto {

    private String name;
    private String mobile;

    public User toEntity(){
        return User.builder()
                .name(name)
                .mobile(mobile)
                .build();
    }
}
