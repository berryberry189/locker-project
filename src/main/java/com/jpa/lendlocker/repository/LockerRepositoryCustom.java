package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LockerResponseDto;
import com.jpa.lendlocker.dto.LockerSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LockerRepositoryCustom {

    Page<LockerResponseDto> search(LockerSearchCondition condition, Pageable pageable);
}
