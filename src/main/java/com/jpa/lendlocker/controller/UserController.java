package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.UserCreateRequestDto;
import com.jpa.lendlocker.dto.UserSearchCondition;
import com.jpa.lendlocker.dto.UserUpdateRequestDto;
import com.jpa.lendlocker.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 검색 목록
     * @param
     * @return List<UserResponseDto>
     */
    @ApiOperation(value = "사용자 검색 목록 조회",
                  notes = "사용자 ID 내림차순으로 조회합니다.\n" +
                          "검색 조건이 없을 경우 전체 조회되며 페이징 처리를 하여 보여줍니다.")
    @GetMapping("/")
    public ResponseEntity searchlist(UserSearchCondition condition, Pageable pagable){

        return new ResponseEntity(userService.search(condition, pagable), HttpStatus.OK);
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
