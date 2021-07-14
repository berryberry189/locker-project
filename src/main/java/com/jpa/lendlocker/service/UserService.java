package com.jpa.lendlocker.service;

import com.jpa.lendlocker.dto.UserLendResponseDto;
import com.jpa.lendlocker.dto.UserRequestDto;
import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
     * @return
     */
    public List<User> findAll(){
        return userRepository.findAll();
    }


    /**
     * 회원 신규 등록
     * @param userRequestDto
     * @return
     */
    @Transactional
    public Long join(UserRequestDto userRequestDto) {
        User user = userRepository.findByUserId(userRequestDto.getUserId());
        if(user != null)  throw new IllegalArgumentException("이미 있는 아이디 입니다.");
        return userRepository.save(userRequestDto.toEntity()).getId();
    }

    /**
     * 회원 수정
     * @param id
     * @param userRequestDto
     * @return updated id
     */
    @Transactional
    public Long update(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원 입니다."));

        if(userRequestDto != null){
            userRepository.save(user.update(userRequestDto));
        }
        return user.getId();
    }

    /**
     * 회원 상세
     * @param id
     * @return userDto
     */
    public UserLendResponseDto datail(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원 입니다."));

        UserLendResponseDto userLendResponseDto = new UserLendResponseDto(user);

        return userLendResponseDto;
    }

    /**
     * 회원 삭제
     * @param id
     * @return deleted Id
     */
    @Transactional
    public Long deleteById(Long id) {
        Long idx = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원 입니다.")).getId();

        userRepository.deleteById(idx);

        return idx;
    }
}
