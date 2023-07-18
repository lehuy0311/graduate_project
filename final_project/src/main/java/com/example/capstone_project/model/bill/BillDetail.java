package com.example.capstone_project.model.bill;

import com.example.capstone_project.model.animal.Animal;

import javax.persistence.*;

@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantityBuy;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;

    public BillDetail() {
    }

    public BillDetail(Integer id, Integer quantityBuy, Bill bill, Animal animal) {
        this.id = id;
        this.quantityBuy = quantityBuy;
        this.bill = bill;
        this.animal = animal;
    }

    public BillDetail(Integer quantityBuy, Bill bill, Animal animal) {
        this.quantityBuy = quantityBuy;
        this.bill = bill;
        this.animal = animal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityBuy() {
        return quantityBuy;
    }

    public void setQuantityBuy(Integer quantityBuy) {
        this.quantityBuy = quantityBuy;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
