package com.jpa.lendlocker.service;

import com.jpa.lendlocker.dto.LockerRequestDto;
import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.repository.LockerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LockerService {

    private final LockerRepository lockerRepository;


    public List<Locker> findByAreaId(Long areaId) {
        return lockerRepository.findByAreaId(areaId);
    }

    /**
     * 보관함 신규 등록
     * @param lockerRequestDto
     * @return
     */
    @Transactional
    public Long create(LockerRequestDto lockerRequestDto) {
        Locker locker = lockerRepository.findByLockerId(
                new LockerId(lockerRequestDto.getAreaId(), lockerRequestDto.getLockerNo()));
        if(locker != null)  throw new IllegalArgumentException("이미 있는 보관함 번호 입니다.");
        lockerRequestDto.setUseYn("N");
        return lockerRepository.save(lockerRequestDto.toEntity()).getLockerId().getLockerNo();
    }

    /**
     * 보관함 수정
     * @param lockerRequestDto
     * @return
     */
    @Transactional
    public Long update(Long areaId, Long lockerNo, LockerRequestDto lockerRequestDto) {
        Locker locker = lockerRepository.findByLockerId(new LockerId(areaId, lockerNo));
        if(locker == null)  throw new IllegalArgumentException("존재하지 않는 보관함 번호 입니다.");

        if(lockerRequestDto != null){
            lockerRepository.save(locker.update(lockerRequestDto));
        }

        return locker.getLockerId().getLockerNo();
    }
}
