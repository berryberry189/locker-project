package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.UserDto;
import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 목록
     */
    @GetMapping("/")
    public List<UserDto> list(){

        List<User> users = userService.findAll();
        List<UserDto> result = users.stream()
                .map(UserDto::new).collect(Collectors.toList());

        return result;
    }

    /**
     * 등록
     */
    @PostMapping("/")
    public String join(@RequestBody @Valid UserDto dto){

        return userService.join(dto);
    }

    /**
     * 등록
     */
    @PutMapping("/{id}")
    public String update(@PathVariable("id") String id,
                         @RequestBody @Valid UserDto dto){

        return userService.update(id, dto);
    }




}
