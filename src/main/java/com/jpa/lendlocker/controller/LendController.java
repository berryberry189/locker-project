package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.LendRequestDto;
import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.entity.Lend;
import com.jpa.lendlocker.service.LendService;
import com.jpa.lendlocker.service.LockerService;
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
public class LendController {

    private final LendService lendService;
    private final LockerService lockerService;

    /**
     * 목록
     * @param
     * @return List<LendResponseDto>
     */
    @ApiOperation(value = "대여 목록 조회",
                  notes = "모든 대여 목록을 조회합니다.")
    @GetMapping("/lend")
    public List<LendResponseDto> list(){
        List<Lend> lends = lendService.findAll();
        List<LendResponseDto> result = lends.stream()
                .map(LendResponseDto::new).collect(Collectors.toList());
        return result;
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
