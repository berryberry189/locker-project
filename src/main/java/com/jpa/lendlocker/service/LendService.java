package com.jpa.lendlocker.service;

import com.jpa.lendlocker.dto.LendRequestDto;
import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.dto.LendSearchCondition;
import com.jpa.lendlocker.entity.*;
import com.jpa.lendlocker.repository.LendRepository;
import com.jpa.lendlocker.repository.LockerRepository;
import com.jpa.lendlocker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LendService {

    private final LendRepository lendRepository;
    private final LockerRepository lockerRepository;
    private final UserRepository userRepository;

    /**
     * 전체 대여 목록
     * @return
     */
    public List<Lend> findAll() {
        return lendRepository.findAll();
    }

    /**
     * 검색 대여 목록
     * @return
     */
    public Page<LendResponseDto> search(LendSearchCondition condition, Pageable pageable) {
        return lendRepository.search(condition, pageable);
    }

    /**
     * 대여
     * @param lendRequestDto
     * @return
     */
    @Transactional
    public Long lend(LendRequestDto lendRequestDto) {
        // 엔티티 조회
        User user = userRepository.findById(lendRequestDto.getUserKey())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원 입니다."));
        Locker locker = lockerRepository.findById(
                new LockerId(lendRequestDto.getAreaId(), lendRequestDto.getLockerNo()))
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 보관함 입니다."));

         return lendRepository.save(lendRequestDto.toEntity(user, locker)).getId();
    }

    /**
     * 반납
     * @param id
     * @return
     */
    @Transactional
    public Long returnLend(Long id) {
        // 엔티티 조회
        Lend lend = lendRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 대여 정보 입니다."));
        Locker locker = lockerRepository.findById(lend.getLocker().getLockerId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 보관함 입니다."));
        lend.returnLend(id, locker);
        return lend.getId();
    }

    public Boolean checkDuplication(LendRequestDto lendRequestDto) {
        // 구역 id, 보관함 no, 대여 상태가 lend인 row가 0인 것을 확인
        return lendRepository.checkDuplication(new LockerId(lendRequestDto.getAreaId(), lendRequestDto.getLockerNo()));
    }
}
