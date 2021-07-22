package com.jpa.lendlocker.service;

import com.jpa.lendlocker.dto.*;
import com.jpa.lendlocker.entity.User;
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
public class UserService {

    private final UserRepository userRepository;


    /**
     * 회원 전체목록
     * @return List<User>
     */
    public List<User> findAll(){
        return userRepository.findAll();
    }

    /**
     * 회원 검색
     * @param condition, pagable
     * @return userLendResponseDto
     */
    public Page<UserResponseDto> search(UserSearchCondition condition, Pageable pagable) {
        return userRepository.search(condition, pagable);
    }

    /**
     * 회원 상세
     * @param userKey
     * @return userLendResponseDto
     */
    public UserResponseDto datail(Long userKey){

        return userRepository.getDetailByUserKey(userKey);
    }

    /**
     * 회원 신규 등록
     * @param userCreateRequestDto
     * @return created id
     */
    @Transactional
    public Long join(UserCreateRequestDto userCreateRequestDto) {
        User user = userRepository.findByUserId(userCreateRequestDto.getUserId());
        if(user != null)  throw new IllegalArgumentException("이미 있는 아이디 입니다.");
        return userRepository.save(userCreateRequestDto.toEntity()).getUserKey();
    }

    /**
     * 회원 수정
     * @param userKey
     * @param userUpdateRequestDto
     * @return updated id
     */
    @Transactional
    public Long update(Long userKey, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(userKey)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원 입니다."));

        if(userUpdateRequestDto != null){
            userRepository.save(user.update(userUpdateRequestDto));
        }
        return user.getUserKey();
    }

    /**
     * 회원 삭제
     * @param userKey
     * @return deleted Id
     */
    @Transactional
    public Long deleteById(Long userKey) {
        Long id = userRepository.findById(userKey)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원 입니다.")).getUserKey();

        userRepository.deleteById(id);

        return id;
    }
}
