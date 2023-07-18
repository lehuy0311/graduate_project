package com.example.capstone_project.dto.animal;

public class AnimalFromCartDTO {
    private int id;
    private String picture;
    private String nameAnimalFromCartDTO;
    private double priceAnimalFromCartDTO;
    private int quantityAnimalFromCartDTO;
    private double totalPrice;

    public AnimalFromCartDTO(int id, String picture, String nameAnimalFromCartDTO, double priceAnimalFromCartDTO, int quantityAnimalFromCartDTO, double totalPrice) {
        this.id = id;
        this.picture = picture;
        this.nameAnimalFromCartDTO = nameAnimalFromCartDTO;
        this.priceAnimalFromCartDTO = priceAnimalFromCartDTO;
        this.quantityAnimalFromCartDTO = quantityAnimalFromCartDTO;
        this.totalPrice = totalPrice;
    }

    public AnimalFromCartDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNameAnimalFromCartDTO() {
        return nameAnimalFromCartDTO;
    }

    public void setNameAnimalFromCartDTO(String nameAnimalFromCartDTO) {
        this.nameAnimalFromCartDTO = nameAnimalFromCartDTO;
    }

    public double getPriceAnimalFromCartDTO() {
        return priceAnimalFromCartDTO;
    }

    public void setPriceAnimalFromCartDTO(double priceAnimalFromCartDTO) {
        this.priceAnimalFromCartDTO = priceAnimalFromCartDTO;
    }

    public int getQuantityAnimalFromCartDTO() {
        return quantityAnimalFromCartDTO;
    }

    public void setQuantityAnimalFromCartDTO(int quantityAnimalFromCartDTO) {
        this.quantityAnimalFromCartDTO = quantityAnimalFromCartDTO;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
