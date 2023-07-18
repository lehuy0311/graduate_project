package com.example.capstone_project.repository.user;

import com.example.capstone_project.model.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUserName(String username);
}
