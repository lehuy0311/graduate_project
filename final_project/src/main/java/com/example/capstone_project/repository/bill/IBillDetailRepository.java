package com.example.capstone_project.repository.bill;

import com.example.capstone_project.controller.billDetail.BilDetail;
import com.example.capstone_project.model.bill.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
    @Query(value = "select * from bill_detail where bill_id = ?" ,nativeQuery = true)
    List<BilDetail> getAllBillDetail(int id);
}
