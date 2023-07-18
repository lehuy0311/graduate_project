package com.example.capstone_project.service.cart;

import com.example.capstone_project.dto.animal.AnimalFromCartDTO;
import com.example.capstone_project.dto.cart.CartDTO;
import com.example.capstone_project.model.animal.Animal;

import java.util.List;

public interface ICartService {

    void addToCart(Animal animal, CartDTO cartDTO);
    void changeQuantity(int id, int quantity, CartDTO cartDTO);

    double totalBill(List<AnimalFromCartDTO> animalFromCartDTOList);

    boolean checkQuantity(int id, int quantity);
}
