package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
