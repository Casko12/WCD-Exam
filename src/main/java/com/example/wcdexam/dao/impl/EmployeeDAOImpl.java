package com.example.wcdexam.dao.impl;

import com.example.wcdexam.dao.EmployeeDAO;
import com.example.wcdexam.entity.EmployeeEntity;
import com.example.wcdexam.util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    EntityManager entityManager;
    EntityTransaction transaction;
    public EmployeeDAOImpl(){
        entityManager = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public void createEmployee(EmployeeEntity employee) {
        try{
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
        }catch(Exception ex){
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public List<EmployeeEntity> getAll() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try{
            Query query  = entityManager.createQuery("select e from EmployeeEntity e");
            return query.getResultList();
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return employees;
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            transaction.begin();
            EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
            entityManager.remove(employee);
            transaction.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public void updateEmployee( EmployeeEntity employee) {
        try {
            transaction.begin();
            EmployeeEntity e = entityManager.find(EmployeeEntity.class, employee.getId());
            e.setName(employee.getName());
            e.setBirthday(employee.getBirthday());
            e.setAddress(employee.getAddress());
            e.setPosition(employee.getPosition());
            e.setDepartment(employee.getDepartment());
            entityManager.merge(e);
            transaction.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public EmployeeEntity getById(int id) {
        EmployeeEntity employee = new EmployeeEntity();
        try{
            employee = entityManager.find(EmployeeEntity.class, id);
            return employee;
        }catch (Exception ex) {
            System.out.printf(ex.getMessage());

        }
        return employee;
    }
}
