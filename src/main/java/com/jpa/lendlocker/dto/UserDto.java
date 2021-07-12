package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserDto {

    private String id;
    private String name;
    private String mobile;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.mobile = user.getMobile();
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .mobile(mobile).build();
    }
}
