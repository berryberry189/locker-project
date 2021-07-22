package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.LendRequestDto;
import com.jpa.lendlocker.dto.LendSearchCondition;
import com.jpa.lendlocker.service.LendService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LendController {

    private final LendService lendService;

    /**
     * 대여 검색 목록
     * @param
     * @return List<LendResponseDto>
     */
    @ApiOperation(value = "대여 검색 목록 조회",
                  notes = "검색 대여 목록을 조회합니다.")
    @GetMapping("/lend")
    public ResponseEntity searchlist(LendSearchCondition condition, Pageable pageable){
        return new ResponseEntity(lendService.search(condition, pageable), HttpStatus.OK);
    }

    /**
     * 대여
     * @param lendRequestDto
     * @return
     */
    @ApiOperation(value = "사물함 대여",
                  notes = "사물함을 대여합니다.")
    @PostMapping("/lend")
    public ResponseEntity lend(@RequestBody LendRequestDto lendRequestDto){
        return new ResponseEntity(lendService.lend(lendRequestDto), HttpStatus.CREATED);
    }

    /**
     * 반납
     * @param id
     * @return
     */
    @ApiOperation(value = "사물함 반납",
                  notes = "대여한 사물함을 반납합니다.")
    @PutMapping("/return/{id}")
    public ResponseEntity returnLend(@PathVariable Long id){
        return new ResponseEntity(lendService.returnLend(id),HttpStatus.OK);
    }

}
