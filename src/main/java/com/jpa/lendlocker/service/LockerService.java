package com.jpa.lendlocker.service;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.repository.LockerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LockerService {

    private final LockerRepository lockerRepository;


    public List<Locker> findByAreaId(Long areaId) {
        return lockerRepository.findByAreaId(areaId);
    }
}
