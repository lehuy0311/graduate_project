package com.example.capstone_project.service.bill;

import com.example.capstone_project.model.bill.Bill;

import java.util.List;

public interface IBillService {
    void saveBill(Bill bill);

    Bill getBillById(int id);

    List<Bill> getBillByIdUser(int idOfCustomer);
}
