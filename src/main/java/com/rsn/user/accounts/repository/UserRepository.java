package com.rsn.user.accounts.repository;

import com.rsn.user.accounts.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);
    User findByName(String name);
}
