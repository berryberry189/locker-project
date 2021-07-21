package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LockerRepository extends JpaRepository<Locker, LockerId>, LockerRepositoryCustom {

    @Query("select l from Locker l where l.area.id = :areaId order by l.lockerId.lockerNo")
    List<Locker> findByAreaId(Long areaId);
}
