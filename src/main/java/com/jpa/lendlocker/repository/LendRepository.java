package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.entity.Lend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendRepository extends JpaRepository<Lend, Long>, LendRepositoryCustom {
}
