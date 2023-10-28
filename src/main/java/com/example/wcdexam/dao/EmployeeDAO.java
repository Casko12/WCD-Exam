package com.example.wcdexam.dao;
import com.example.wcdexam.entity.EmployeeEntity;
import java.util.List;
public interface EmployeeDAO {
    void createEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAll();

    void updateEmployee(EmployeeEntity employee);
    void deleteEmployee(int id);
    EmployeeEntity getById(int id);
}

