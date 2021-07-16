package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.UserCreateRequestDto;
import com.jpa.lendlocker.dto.UserResponseDto;
import com.jpa.lendlocker.dto.UserUpdateRequestDto;
import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @param
     * @return List<UserResponseDto>
     */
    @ApiOperation(value = "사용자 목록 조회",
                  notes = "모든 사용자 목록을 조회합니다.")
    @GetMapping("/")
    public List<UserResponseDto> list(){

        List<User> users = userService.findAll();
        List<UserResponseDto> result = users.stream()
                .map(UserResponseDto::new).collect(Collectors.toList());

        return result;
    }

    /**
     * 상세
     * @param userKey
     * @return
     */
    @ApiOperation(value = "사용자 상세",
                  notes = "userKey로 조회하여 사용자의 상세 정보를 조회합니다.")
    @GetMapping("/{userKey}")
    public ResponseEntity datail(@PathVariable Long userKey){
        return new ResponseEntity(userService.datail(userKey), HttpStatus.OK);
    }

    /**
     * 등록
     * @param userCreateRequestDto
     * @return
     */
    @ApiOperation(value = "사용자 등록",
                  notes = "사용자를 등록합니다.")
    @PostMapping("/")
    public ResponseEntity join(@RequestBody UserCreateRequestDto userCreateRequestDto){

        return new ResponseEntity(userService.join(userCreateRequestDto), HttpStatus.CREATED);
    }

    /**
     * 수정
     * @param userUpdateRequestDto
     * @return
     */
    @ApiOperation(value = "사용자 수정",
                  notes = "userKey로 조회하여 사용자를 등록합니다.")
    @PutMapping("/{userKey}")
    public ResponseEntity update(@PathVariable Long userKey,
                                 @RequestBody UserUpdateRequestDto userUpdateRequestDto){

        return new ResponseEntity(userService.update(userKey, userUpdateRequestDto), HttpStatus.OK);
    }

    /**
     * 삭제
     * @param userKey
     * @return
     */
    @ApiOperation(value = "사용자 삭제",
                  notes = "userKey로 조회하여 사용자를 삭제합니다.")
    @DeleteMapping("/{userKey}")
    public ResponseEntity delete(@PathVariable Long userKey){
        return new ResponseEntity(userService.deleteById(userKey), HttpStatus.OK);
    }
}
