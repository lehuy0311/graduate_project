package com.example.capstone_project.service.bill.impl;

import com.example.capstone_project.controller.billDetail.BilDetail;
import com.example.capstone_project.model.bill.BillDetail;
import com.example.capstone_project.repository.bill.IBillDetailRepository;
import com.example.capstone_project.service.bill.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService implements IBillDetailService {
    @Autowired
    private IBillDetailRepository billDetailRepository;
    @Override
    public void saveBillDetail(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }

    @Override
    public List<BilDetail> disPlayBill(int id) {
        return billDetailRepository.getAllBillDetail(id);
    }
}
