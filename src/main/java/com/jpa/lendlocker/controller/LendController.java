package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.LendRequestDto;
import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.entity.Lend;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.service.LendService;
import com.jpa.lendlocker.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
     */
    @GetMapping("/lend")
    public List<LendResponseDto> list(){
        List<Lend> lends = lendService.findAll();
        List<LendResponseDto> result = lends.stream()
                .map(LendResponseDto::new).collect(Collectors.toList());
        return result;
    }

    /**
     * 대여
     */
    @PostMapping("/lend")
    public ResponseEntity lend(@RequestBody @Valid LendRequestDto lendRequestDto){
        // locker useYn 변경
        lockerService.changeUseYn(
                new LockerId(lendRequestDto.getAreaId(), lendRequestDto.getLockerNo()));
        return new ResponseEntity(lendService.lend(lendRequestDto), HttpStatus.CREATED);
    }


}
