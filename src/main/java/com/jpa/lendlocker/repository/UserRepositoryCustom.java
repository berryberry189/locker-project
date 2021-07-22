package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.UserResponseDto;
import com.jpa.lendlocker.dto.UserSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {

    // 검색
    Page<UserResponseDto> search(UserSearchCondition condition, Pageable pagable);

    // 사용자 상세 ( +사용자별 락커 갯수 )
    UserResponseDto getDetailByUserKey(Long userKey);
}
