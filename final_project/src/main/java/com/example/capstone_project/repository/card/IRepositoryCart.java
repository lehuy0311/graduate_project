package com.example.capstone_project.repository.card;

import com.example.capstone_project.model.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCart extends JpaRepository<Animal,Integer> {

}
