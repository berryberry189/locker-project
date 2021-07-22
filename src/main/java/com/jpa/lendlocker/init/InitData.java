package com.jpa.lendlocker.init;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerArea;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.entity.User;
import com.jpa.lendlocker.enums.LockerType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitData {

    private final InitDataService initDataService;

    @PostConstruct
    public void init(){
        initDataService.initUser();
        initDataService.initArea();
        initDataService.initLocker();
    }

    @Component
    static class InitDataService{
        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void initUser(){

            for(int i=0; i<100; i++){
                em.persist(new User("userId"+i, "회원"+i, "010-1111-"+i));
            }
        }

        @Transactional
        public void initArea(){
            for(int i=1; i<=10; i++){
                em.persist(new LockerArea("구역"+ i));
            }
        }

        @Transactional
        public void initLocker(){
            //em.flush();
            //em.clear();
            LockerArea area = new LockerArea();
            area.setId(1L); area.setName("구역1");
            for(int i=1; i<=20; i++){
                LockerType type = (i%3 == 0) ? LockerType.LARGE : ( i%3 == 1 ? LockerType.SMALL : LockerType.MEDIUM);
                int price = (i%3 == 0) ? 5000 : ( i%3 == 1 ? 2000 : 3000);
                LockerId lockerId = new LockerId(1L, Long.valueOf(i));
                em.merge(new Locker(area, lockerId, type, price, "Y"));
            }
        }

    }



}
