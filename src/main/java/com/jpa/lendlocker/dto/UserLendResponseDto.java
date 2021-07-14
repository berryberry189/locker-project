package com.jpa.lendlocker.dto;

import com.jpa.lendlocker.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter @Setter
public class UserLendResponseDto {

    private String userId;
    private String name;
    private String mobile;
    private List<LendResponseDto> lends;

    public UserLendResponseDto(User user) {

        this.userId = user.getUserId();
        this.name = user.getName();
        this.mobile = user.getMobile();
        this.lends = user.getLends().stream()
                .map(LendResponseDto::new)
                .collect(Collectors.toList());
    }
}
