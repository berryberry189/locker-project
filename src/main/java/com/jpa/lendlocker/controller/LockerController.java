package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.LockerCreateRequestDto;
import com.jpa.lendlocker.dto.LockerResponseDto;
import com.jpa.lendlocker.dto.LockerUpdateRequestDto;
import com.jpa.lendlocker.entity.Locker;
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
@RequestMapping("/locker")
public class LockerController {

    private final LockerService lockerService;

    /**
     * 전체 보관함 목록
     * @param
     * @return List<LockerResponseDto>
     */
    @ApiOperation(value = "전체 보관함 목록 조회",
                  notes = "전체 보관함 목록을 조회합니다.")
    @GetMapping("/")
    public ResponseEntity list(){
        List<Locker> lockers = lockerService.findAll();
        List<LockerResponseDto> result = lockers.stream()
                .map(LockerResponseDto::new).collect(Collectors.toList());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 구역 별 보관함 목록
     * @param areaId
     * @return List<LockerResponseDto>
     */
    @ApiOperation(value = "구역 별 보관함 목록 조회",
                  notes = "구역 별 모든 보관함 목록을 조회합니다.")
    @GetMapping("/{areaId}")
    public ResponseEntity listByAreaId(@PathVariable Long areaId){
        List<Locker> lockers = lockerService.findByAreaId(areaId);
        List<LockerResponseDto> result = lockers.stream()
                .map(LockerResponseDto::new).collect(Collectors.toList());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 등록
     * @param lockerCreateRequestDto
     * @return
     */
    @ApiOperation(value = "보관함 등록",
                  notes = "보관함을 신규 등록합니다.")
    @PostMapping("/")
    public ResponseEntity create(@RequestBody LockerCreateRequestDto lockerCreateRequestDto){
        return new ResponseEntity(lockerService.create(lockerCreateRequestDto), HttpStatus.CREATED);
    }

    /**
     * 수정
     * @param areaId, lockerNo, lockerRequestDto
     * @return
     */
    @ApiOperation(value = "보관함 수정",
                  notes = "구역id와 보관함no로 조회하여 보관함의 정보를 수정합니다.")
    @PutMapping("/{areaId}/{lockerNo}")
    public ResponseEntity update(@PathVariable Long areaId,
                                 @PathVariable Long lockerNo,
                                 @RequestBody LockerUpdateRequestDto lockerUpdateRequestDto){
        return new ResponseEntity(lockerService.update(areaId, lockerNo, lockerUpdateRequestDto), HttpStatus.OK);
    }

    /**
     * 삭제
     * @param areaId, lockerNo
     * @return
     */
    @ApiOperation(value = "보관함 삭제",
                  notes = "구역id와 보관함no로 조회하여 보관함을 삭제합니다.")
    @DeleteMapping("/{areaId}/{lockerNo}")
    public ResponseEntity delete(@PathVariable Long areaId,
                                 @PathVariable Long lockerNo){
        return new ResponseEntity(lockerService.deleteByLockerId(areaId, lockerNo), HttpStatus.OK);
    }


}
