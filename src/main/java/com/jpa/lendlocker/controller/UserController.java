package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.UserRequestDto;
import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.service.UserService;
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
     */
    @GetMapping("/")
    public List<UserRequestDto> list(){

        List<User> users = userService.findAll();
        List<UserRequestDto> result = users.stream()
                .map(UserRequestDto::new).collect(Collectors.toList());

        return result;
    }

    /**
     * 등록
     * @return
     */
    @PostMapping("/")
    public ResponseEntity join(@RequestBody @Valid UserRequestDto dto){

        return new ResponseEntity(userService.join(dto), HttpStatus.CREATED);
    }

    /**
     * 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody @Valid UserRequestDto dto){

        return new ResponseEntity(userService.update(id, dto), HttpStatus.OK);
    }

    /**
     * 상세
     */
    @GetMapping("/{id}")
    public ResponseEntity datail(@PathVariable Long id){
        return new ResponseEntity(userService.datail(id), HttpStatus.OK);
    }

    /**
     * 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return new ResponseEntity(userService.deleteById(id), HttpStatus.OK);
    }
}
