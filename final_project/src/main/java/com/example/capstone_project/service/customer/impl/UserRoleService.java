package com.example.capstone_project.service.customer.impl;

import com.example.capstone_project.model.login.AppUser;
import com.example.capstone_project.model.login.UserRole;

import com.example.capstone_project.repository.user.IUserRoleRepository;
import com.example.capstone_project.service.customer.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Override
    public List<UserRole> findAllUserRole() {
        return userRoleRepository.findAll();
    }

    @Override
    public void saveUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public void findById(Integer id) {
        userRoleRepository.findById(id);
    }

    @Override
    public void deleteUserRole(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    @Override
    public UserRole findUserRoleByAppUser(AppUser appUser) {
        return userRoleRepository.findUserRoleByAppUser(appUser);
    }
}
