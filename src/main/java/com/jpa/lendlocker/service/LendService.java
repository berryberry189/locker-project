package com.jpa.lendlocker.service;

import com.jpa.lendlocker.entity.Lend;
import com.jpa.lendlocker.repository.LendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LendService {

    private final LendRepository lendRepository;


    public List<Lend> findAll() {
        return lendRepository.findAll();
    }
}
