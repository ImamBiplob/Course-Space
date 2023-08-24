package com.imambiplob.coursespace.repository;

import com.imambiplob.coursespace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}