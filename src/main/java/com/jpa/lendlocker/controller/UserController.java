package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.UserResponseDto;
import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 목록
     *
     */
    @GetMapping("/")
    public List<UserResponseDto> list(){

        List<User> users = userService.findAll();
        List<UserResponseDto> result = users.stream()
                .map(UserResponseDto::new).collect(Collectors.toList());

        return result;
    }

}
