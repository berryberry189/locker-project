package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.dto.LendSearchCondition;
import com.jpa.lendlocker.entity.LockerId;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LendRepositoryCustom {

    Page<LendResponseDto> search(LendSearchCondition condition, Pageable pageable);

    // 중복 체크
    Boolean checkDuplication(LockerId lockerId);

    // 대여건 있는지 체크
    Boolean checkLend(Long userKey);
}
