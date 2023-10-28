package com.example.wcdexam.dao.impl;

import com.example.wcdexam.dao.CustomerDAO;
import com.example.wcdexam.entity.CustomerEntity;
import com.example.wcdexam.util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    EntityManager entityManager;
    EntityTransaction transaction;
    public CustomerDAOImpl(){
        entityManager = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public void createCustomer(CustomerEntity customer) {
        try{
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
        }catch(Exception ex){
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public List<CustomerEntity> getAll() {
        List<CustomerEntity> customers = new ArrayList<>();
        try{
            Query query  = entityManager.createQuery("select s from CustomerEntity s");
            return query.getResultList();
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return customers;
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            transaction.begin();
            CustomerEntity customer = entityManager.find(CustomerEntity.class, id);
            entityManager.remove(customer);
            transaction.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public void updateCustomer( CustomerEntity customer) {
        try {
            transaction.begin();
            CustomerEntity c = entityManager.find(CustomerEntity.class, customer.getId());
            c.setName(customer.getName());
            c.setAge(customer.getAge());
            c.setAddress(customer.getAddress());
            c.setBirthday(customer.getBirthday());
            entityManager.merge(c);
            transaction.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public CustomerEntity getById(int id) {
        CustomerEntity customer = new CustomerEntity();
        try{
            customer = entityManager.find(CustomerEntity.class, id);
            return customer;
        }catch (Exception ex) {
            System.out.printf(ex.getMessage());

        }
        return customer;
    }
}
