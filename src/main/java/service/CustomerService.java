package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    boolean save(Customer customer);
    
    List<Customer> findAll();
}
