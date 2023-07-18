package com.example.capstone_project.service.customer;

import com.example.capstone_project.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAllCustomer(String name, Pageable pageable);
    void saveCustomer(Customer customer);
    void deleteCustomer(Integer idCustomer);
    Customer findByIdCustomer(Integer idCustomer);
    Page<Customer> findByNameCustomer(String nameCustomer,Pageable pageable);
    Page<Customer> findAllByName(String nameCustomer, PageRequest pageRequest);
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByAppUser_UserName(String userName);

    Customer findByNameAccount(String nameAccount);

    Customer findByUsername(String username);
}
