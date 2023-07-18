package com.example.capstone_project.service.employee.impl;

import com.example.capstone_project.model.employee.Position;
import com.example.capstone_project.repository.employee.IPositionRepository;
import com.example.capstone_project.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
