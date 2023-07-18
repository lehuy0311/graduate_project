package com.example.capstone_project.service.customer;

import com.example.capstone_project.model.login.AppUser;
import com.example.capstone_project.model.login.UserRole;

import java.util.List;

public interface IUserRoleService {
    List<UserRole> findAllUserRole();
    void saveUserRole(UserRole userRole);
    void findById(Integer id);
    void deleteUserRole(UserRole userRole);
    UserRole findUserRoleByAppUser(AppUser appUser);
}
