package com.example.capstone_project.service.animal.impl;

import com.example.capstone_project.model.animal.AnimalType;
import com.example.capstone_project.repository.animal.IAnimalTypeRepository;
import com.example.capstone_project.service.animal.IAnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalTypeService implements IAnimalTypeService {
    @Autowired
    IAnimalTypeRepository animalTypeRepository;

    @Override
    public List<AnimalType> getAll() {
        return animalTypeRepository.findAll();
    }
}
