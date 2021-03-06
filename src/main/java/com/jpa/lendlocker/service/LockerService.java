package com.jpa.lendlocker.service;

import com.jpa.lendlocker.dto.LockerCreateRequestDto;
import com.jpa.lendlocker.dto.LockerResponseDto;
import com.jpa.lendlocker.dto.LockerSearchCondition;
import com.jpa.lendlocker.dto.LockerUpdateRequestDto;
import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.repository.LockerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LockerService {

    private final LockerRepository lockerRepository;

    /**
     * 목록
     * @param
     * @return List<LockerResponseDto>
     */
    public List<Locker> findAll() {
        return lockerRepository.findAll();
    }

    /**
     * 회원 검색
     * @param condition, pageable
     * @return
     */
    public Page<LockerResponseDto> search(LockerSearchCondition condition, Pageable pageable) {
        return lockerRepository.search(condition, pageable);
    }

    /**
     * 구역 별 보관함 목록
     * @param areaId
     * @return
     */
    public List<Locker> findByAreaId(Long areaId) {
        return lockerRepository.findByAreaId(areaId);
    }

    /**
     * 보관함 신규 등록
     * @param lockerCreateRequestDto
     * @return
     */
    @Transactional
    public Long create(LockerCreateRequestDto lockerCreateRequestDto) {
        LockerId lockerId = new LockerId(lockerCreateRequestDto.getAreaId(), lockerCreateRequestDto.getLockerNo());
        Optional<Locker> locker = lockerRepository.findById(lockerId);
        if(locker != null)  throw new IllegalArgumentException("이미 있는 보관함 번호 입니다.");
        lockerCreateRequestDto.setUseYn("N");
        return lockerRepository.save(lockerCreateRequestDto.toEntity()).getLockerId().getLockerNo();
    }

    /**
     * 보관함 수정
     * @param lockerUpdateRequestDto
     * @return
     */
    @Transactional
    public Long update(Long areaId, Long lockerNo, LockerUpdateRequestDto lockerUpdateRequestDto) {
        LockerId lockerId = new LockerId(areaId, lockerNo);
        Locker locker = lockerRepository.findById(lockerId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 보관함 번호 입니다."));

        if(lockerUpdateRequestDto != null){
            locker.update(lockerUpdateRequestDto);
        }

        return locker.getLockerId().getLockerNo();
    }

    @Transactional
    public Long deleteByLockerId(Long areaId, Long lockerNo) {
        LockerId lockerId = new LockerId(areaId, lockerNo);
        Locker locker = lockerRepository.findById(lockerId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 보관함 번호 입니다."));

        lockerRepository.deleteById(locker.getLockerId());

        return locker.getLockerId().getLockerNo();
    }

}
