package com.example.capstone_project.repository.bill;

import com.example.capstone_project.model.bill.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "select * from bill join customer on bill.customer_id = customer.id where customer.id = ? ", nativeQuery = true)
    List<Bill> getBillByIdCustomer(int idOfCustomer);
}
