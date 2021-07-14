package com.jpa.lendlocker.controller;

import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.entity.Lend;
import com.jpa.lendlocker.service.LendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lend")
public class LendController {

    private final LendService lendService;

    /**
     * 목록
     */
    @GetMapping("/")
    public List<LendResponseDto> list(){
        List<Lend> lends = lendService.findAll();
        List<LendResponseDto> result = lends.stream()
                .map(LendResponseDto::new).collect(Collectors.toList());
        return result;
    }

}
