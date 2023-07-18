package com.example.capstone_project.dto.cart;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartDTO {
    private final Map<Integer,Integer> selectedAnimals;
    public CartDTO() {
        this.selectedAnimals = new LinkedHashMap<>();
    }

    public Map<Integer, Integer> getSelectedAnimals() {
        return selectedAnimals;
    }
}
