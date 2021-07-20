package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.dto.LendSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LendRepositoryCustom {

    Page<LendResponseDto> search(LendSearchCondition condition, Pageable pageable);
}
