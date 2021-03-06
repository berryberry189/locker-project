package com.jpa.lendlocker.entity;

import com.jpa.lendlocker.dto.UserUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
@NoArgsConstructor // @Builder 사용할때 써줌
public class User{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_key")
    private Long userKey;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_mobile")
    private String mobile;

    @Builder
    public User(String userId, String name, String mobile){
        this.userId = userId;
        this.name = name;
        this.mobile = mobile;
    }

    public User update(UserUpdateRequestDto userUpdateRequestDto){
        this.name = userUpdateRequestDto.getName();
        this.mobile = userUpdateRequestDto.getMobile();
        return this;
    }

}
