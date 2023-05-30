package com.example.springformbase_thymeleaf.repository;


import com.example.springformbase_thymeleaf.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String username);
}
