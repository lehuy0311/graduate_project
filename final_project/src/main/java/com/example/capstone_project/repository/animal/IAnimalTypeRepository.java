package com.example.capstone_project.repository.animal;

import com.example.capstone_project.model.animal.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalTypeRepository extends JpaRepository<AnimalType,Integer> {
}
