package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LockerResponseDto;
import com.jpa.lendlocker.dto.LockerSearchCondition;
import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerArea;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.enums.LockerType;
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
public class LockerRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired LockerRepository lockerRepository;

    @Test
    public void searchTest(){
        // given
        LockerArea area = new LockerArea();
        area.setId(1L); area.setName("구역1");
        LockerId lockerId1 = new LockerId(1L, 1L);
        lockerRepository.save(Locker.builder()
                .area(area)
                .lockerId(lockerId1)
                .price(5000)
                .type(LockerType.LARGE)
                .useYn("Y")
                .build());

        LockerId lockerId2 = new LockerId(1L, 2L);
        lockerRepository.save(Locker.builder()
                .area(area)
                .lockerId(lockerId2)
                .price(3000)
                .type(LockerType.MEDIUM)
                .useYn("Y")
                .build());

        LockerId lockerId3 = new LockerId(1L, 3L);
        lockerRepository.save(Locker.builder()
                .area(area)
                .lockerId(lockerId3)
                .price(2000)
                .type(LockerType.SMALL)
                .useYn("N")
                .build());

        LockerSearchCondition condition = new LockerSearchCondition();
        //condition.setLockerId(lockerId1);
        //condition.setType(LockerType.LARGE);
        //condition.setUseYn("Y");

        PageRequest pageRequest = PageRequest.of(0, 2);

        // when
        Page<LockerResponseDto> results = lockerRepository.search(condition, pageRequest);

        // then
        Assertions.assertThat(results.getTotalElements()).isEqualTo(3);
        Assertions.assertThat(results.getTotalPages()).isEqualTo(2);
        //Assertions.assertThat(results.getTotalElements()).isEqualTo(2);
    }
}
