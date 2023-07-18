package com.example.capstone_project.repository.user;

import com.example.capstone_project.model.login.AppUser;
import com.example.capstone_project.model.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByAppUser(AppUser appUser);
    UserRole findUserRoleByAppUser(AppUser appUser);

}
