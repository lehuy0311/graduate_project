package com.example.capstone_project.service.bill;

import com.example.capstone_project.controller.billDetail.BilDetail;
import com.example.capstone_project.model.bill.BillDetail;

import java.util.List;

public interface IBillDetailService {
    void saveBillDetail(BillDetail billDetail);

    List<BilDetail> disPlayBill(int id);
}
