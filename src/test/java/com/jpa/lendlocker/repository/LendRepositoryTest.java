package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.dto.LendSearchCondition;
import com.jpa.lendlocker.entity.*;
import com.jpa.lendlocker.enums.LendStatus;
import com.jpa.lendlocker.enums.LockerType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class LendRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired LendRepository lendRepository;
    @Autowired UserRepository userRepository;
    @Autowired LockerAreaRepository lockerAreaRepository;
    @Autowired LockerRepository lockerRepository;

    private void setTestData() {
        User user = User.builder()
                .userId("userA")
                .name("김회원")
                .mobile("010-1111-2222")
                .build();
        userRepository.save(user);

        LockerArea area = new LockerArea();
        area.setId(1L);
        area.setName("구역1");
        lockerAreaRepository.save(area);

        LockerId lockerId1 = new LockerId(1L, 1L);
        Locker locker = Locker.builder()
                .area(area)
                .lockerId(lockerId1)
                .price(5000)
                .type(LockerType.LARGE)
                .useYn("Y")
                .build();
        lockerRepository.save(locker);

        Lend lend = Lend.builder()
                .user(user)
                .locker(locker)
                .hour(3)
                .price(15000)
                .status(LendStatus.LEND)
                .lendDate(LocalDateTime.now().minusDays(1))
                .build();
        lendRepository.save(lend);
    }

    @Test
    public void searchTest(){
        // given
        setTestData();

        LendSearchCondition condition = new LendSearchCondition();
        //condition.setAreaName("구역1");
        //condition.setUserId("userB");
        //condition.setStatus(LendStatus.LEND);
        //condition.setStartDateTime();
        condition.setStartDateTime(LocalDateTime.now().minusDays(3));
        condition.setEndDateTime(LocalDateTime.now());

        Pageable pageable = PageRequest.of(0, 10);

        // when
        Page<LendResponseDto> result = lendRepository.search(condition,pageable);

        // then
        Assertions.assertThat(result.getTotalElements()).isEqualTo(1);

        for(LendResponseDto dto : result){
            System.out.println("dto = " + dto.getAreaName() + " / " +dto.getLockerNo()
                    + " / " + dto.getUserId() + " / " + dto.getLendDate());
        }
    }

    @Test
    public void checkLendTest(){
        // given
        setTestData();

        // when
        Boolean check = lendRepository.checkLend(1L);

        // then
        Assertions.assertThat(check).isTrue();
    }

}
