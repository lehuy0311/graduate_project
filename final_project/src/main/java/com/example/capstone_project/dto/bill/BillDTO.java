package com.example.capstone_project.dto.bill;

import java.util.Date;

public class BillDTO {
    private Integer id;
    private Date purchaseDate;
    private Boolean status;
    private Double totalPrice;
    private String animalName;
    private Integer quantityBuy;
    private Double unitPrice;
    private String customerName;

    public BillDTO() {
    }

    public BillDTO(Integer id, Date purchaseDate, Boolean status, Double totalPrice, String animalName, Integer quantityBuy, Double unitPrice, String customerName) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.animalName = animalName;
        this.quantityBuy = quantityBuy;
        this.unitPrice = unitPrice;
        this.customerName = customerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Integer getQuantityBuy() {
        return quantityBuy;
    }

    public void setQuantityBuy(Integer quantityBuy) {
        this.quantityBuy = quantityBuy;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
