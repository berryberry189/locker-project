package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.LockerRequestDto;
import com.jpa.lendlocker.dto.LockerResponseDto;
import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locker")
public class LockerController {

    private final LockerService lockerService;

    /**
     * 목록
     */
    @GetMapping("/")
    public List<LockerResponseDto> list(@RequestBody @Valid LockerRequestDto lockerRequestDto){
        List<Locker> lockers = lockerService.findByAreaId(lockerRequestDto.getAreaId());
        List<LockerResponseDto> result = lockers.stream()
                .map(LockerResponseDto::new).collect(Collectors.toList());
        return result;
    }

    /**
     * 등록
     */
    @PostMapping("/")
    public ResponseEntity create(@RequestBody @Valid LockerRequestDto lockerRequestDto){
        return new ResponseEntity(lockerService.create(lockerRequestDto), HttpStatus.CREATED);
    }




}
