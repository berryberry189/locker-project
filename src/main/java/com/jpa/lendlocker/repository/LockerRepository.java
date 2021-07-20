package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.entity.Locker;
import com.jpa.lendlocker.entity.LockerId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LockerRepository extends JpaRepository<Locker, LockerId>, LockerRepositoryCustom {
    List<Locker> findByAreaId(Long areaId);
}
