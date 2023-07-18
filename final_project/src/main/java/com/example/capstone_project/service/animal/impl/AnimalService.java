package com.example.capstone_project.service.animal.impl;

import com.example.capstone_project.dto.animal.AnimalFromCartDTO;
import com.example.capstone_project.model.animal.Animal;
import com.example.capstone_project.repository.animal.IAnimalRepository;
import com.example.capstone_project.service.animal.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AnimalService implements IAnimalService {
    @Autowired
    IAnimalRepository animalRepository;

    @Override
    public List<Animal> getALl() {
        return animalRepository.findAll();
    }

    @Override
    public void delete(int id) {
        animalRepository.deleteById(id);
    }

    @Override
    public void creat(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public Animal getById(int id) {
        return animalRepository.findById(id).get();
    }

    @Override
    public void updateById(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public Page<Animal> getBlogPage(Pageable pageableAnimal) {
        return animalRepository.findAll(pageableAnimal);
    }

    @Override
    public List<Animal> getAllByType(int id) {
        return animalRepository.findAllByType(id);
    }

    @Override
    public List<Animal> getAnimalsById(Set<Integer> animalIds) {
        return animalRepository.findAllById(animalIds);
    }

    @Override
    public Animal getAnimalByName(String nameAnimalFromCartDTO) {
        return animalRepository.findByName(nameAnimalFromCartDTO);
    }

    @Override
    public List<Animal> findByName(String nameAnimal) {
        return animalRepository.findByNameAnimal(nameAnimal);
    }

    @Override
    public void reduceQuantity(List<AnimalFromCartDTO> animalFromCartDTOList) {
        for (int i = 0; i < animalFromCartDTOList.size(); i++) {
            Animal animal = animalRepository.findById(animalFromCartDTOList.get(i).getId()).get();
            animal.setQuantity(animal.getQuantity() - animalFromCartDTOList.get(i).getQuantityAnimalFromCartDTO());
        }
    }

    @Override
    public Page<Animal> getAnimalPageName(String name, Pageable pageableAnimal) {
        return animalRepository.findAllByNameContaining(name, pageableAnimal);
    }

    @Override
    public Page<Animal> getAnimalByIdName(String search, Integer typeId, Pageable pageableAnimal) {
        return animalRepository.findAllByNameContainingAndAnimalType_Id(search, typeId, pageableAnimal);
    }
}
