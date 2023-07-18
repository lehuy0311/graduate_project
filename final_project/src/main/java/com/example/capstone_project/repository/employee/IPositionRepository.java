package com.example.capstone_project.repository.employee;

import com.example.capstone_project.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
    List<Position> findAll();
}
