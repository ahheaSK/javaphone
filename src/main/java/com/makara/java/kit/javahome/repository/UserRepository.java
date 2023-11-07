package com.makara.java.kit.javahome.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makara.java.kit.javahome.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
}