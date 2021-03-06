package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom{
    User findByUserId(String userId);
}
