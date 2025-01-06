package com.security.login.repo;

import com.security.login.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import com.security.login.entity.Users;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);


}
