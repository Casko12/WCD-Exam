package com.example.wcdexam.dao;
import com.example.wcdexam.entity.CustomerEntity;
import java.util.List;
public interface CustomerDAO {
    void createCustomer(CustomerEntity customer);
    List<CustomerEntity> getAll();

    void updateCustomer(CustomerEntity customer);
    void deleteCustomer(int id);
    CustomerEntity getById(int id);
}

