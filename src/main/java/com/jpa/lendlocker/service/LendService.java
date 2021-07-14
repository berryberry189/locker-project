package com.jpa.lendlocker.service;

import com.jpa.lendlocker.dto.LendRequestDto;
import com.jpa.lendlocker.entity.*;
import com.jpa.lendlocker.repository.LendRepository;
import com.jpa.lendlocker.repository.LockerRepository;
import com.jpa.lendlocker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LendService {

    private final LendRepository lendRepository;
    private final LockerRepository lockerRepository;
    private final UserRepository userRepository;


    public List<Lend> findAll() {
        return lendRepository.findAll();
    }

    @Transactional
    public Long lend(LendRequestDto lendRequestDto) {
        // 엔티티 조회
        User user = userRepository.findById(lendRequestDto.getUserKey()).get();
        Locker locker = lockerRepository.findById(
                new LockerId(lendRequestDto.getAreaId(), lendRequestDto.getLockerNo())).get();

        // 대여 생성
        Lend lend = Lend.lend(user, locker, lendRequestDto);

         return lendRepository.save(lend).getId();
    }

    public Long returnLend(Long id) {
        // 엔티티 조회
        Lend lend = lendRepository.findById(id).get();
        Locker locker = lockerRepository.findById(lend.getLocker().getLockerId()).get();

        // 반납 생성
        lend = Lend.returnLend(locker);

        return lendRepository.save(lend).getId();
    }
}
