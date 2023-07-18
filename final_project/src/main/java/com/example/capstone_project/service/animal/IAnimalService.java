package com.example.capstone_project.service.animal;

import com.example.capstone_project.dto.animal.AnimalFromCartDTO;
import com.example.capstone_project.model.animal.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IAnimalService {
    List<Animal> getALl();

    void delete(int id);

    void creat(Animal animal);

    Animal getById(int id);

    void updateById(Animal animal);

    Page<Animal> getBlogPage(Pageable pageableAnimal);


    List<Animal> getAllByType(int id);

    List<Animal> getAnimalsById(Set<Integer> animalsIds);


    Animal getAnimalByName(String nameAnimalFromCartDTO);

    List<Animal> findByName(String nameAnimal);

    void reduceQuantity(List<AnimalFromCartDTO> animalFromCartDTOList);

    Page<Animal> getAnimalPageName(String name, Pageable pageableAnimal);
    Page<Animal> getAnimalByIdName(String search, Integer typeId, Pageable pageableAnimal);
}
