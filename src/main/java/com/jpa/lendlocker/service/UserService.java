package com.jpa.lendlocker.service;

import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
