package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.dto.LendSearchCondition;
import com.jpa.lendlocker.entity.LockerId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LendRepositoryCustom {

    Page<LendResponseDto> search(LendSearchCondition condition, Pageable pageable);

    // 중복 체크
    Boolean checkDuplication(LockerId lockerId);
}
