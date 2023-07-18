package com.example.capstone_project.repository.animal;

import com.example.capstone_project.model.animal.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal, Integer> {
    @Query(value = "select * from animal join animal_type on animal.animal_type_id = animal_type.id where animal_type.id = ?", nativeQuery = true)
    List<Animal> findAllByType(int id);

    @Query(value = "select * from animal where name = ?", nativeQuery = true)
    Animal findByName(String nameAnimalFromCartDTO);

    @Query(value = "select * from animal where name like concat('%',?,'%')",nativeQuery = true)
    List<Animal> findByNameAnimal(String nameAnimal);

    Page<Animal> findAllByNameContaining(String name, Pageable pageableAnimal);
    Page<Animal> findAllByNameContainingAndAnimalType_Id(String search, Integer typeId, Pageable pageableAnimal);
}