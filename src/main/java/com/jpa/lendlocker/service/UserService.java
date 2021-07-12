package com.jpa.lendlocker.service;

import com.jpa.lendlocker.dto.UserDto;
import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    // 회원 목록 조회
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public String join(UserDto dto) {
        return userRepository.save(dto.toEntity()).getId();
    }

    public String update(String id, UserDto dto) {
        User user = userRepository.findById(id);
        if(StringUtils.isEmpty(user)){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }

        return user.update(dto).getId();

    }
}
