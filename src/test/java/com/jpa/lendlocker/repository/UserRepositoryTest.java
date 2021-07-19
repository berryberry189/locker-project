package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.UserResponseDto;
import com.jpa.lendlocker.dto.UserSearchCondition;
import com.jpa.lendlocker.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired UserRepository userRepository;

    @Test
    public void searchTest(){
        // given
        userRepository.save(User.builder()
                .userId("userA")
                .name("김회원")
                .mobile("010-1111-2222")
                .build());
        userRepository.save(User.builder()
                .userId("userB")
                .name("박회원")
                .mobile("010-1111-3333")
                .build());

        UserSearchCondition condition = new UserSearchCondition();
        condition.setName("회원");
        PageRequest pageRequest = PageRequest.of(0, 5);

        // when
        Page<UserResponseDto> results = userRepository.search(condition, pageRequest);

        // then
        Assertions.assertThat(results.getTotalElements()).isEqualTo(2);
        Assertions.assertThat(results.getTotalPages()).isEqualTo(1);

        for(UserResponseDto dto : results){
            System.out.println("dto = " + dto);
            System.out.println("dto.getName = " + dto.getName());
        }

    }
}
