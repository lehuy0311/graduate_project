package com.example.capstone_project.service.bill.impl;

import com.example.capstone_project.model.bill.Bill;
import com.example.capstone_project.repository.bill.IBillRepository;
import com.example.capstone_project.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {
    @Autowired
    IBillRepository billRepository;
    @Override
    public void saveBill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill getBillById(int id) {
        return billRepository.findById(id).get();
    }

    @Override
    public List<Bill> getBillByIdUser(int idOfCustomer) {
        return billRepository.getBillByIdCustomer(idOfCustomer);
    }
}
