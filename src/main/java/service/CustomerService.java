package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    Customer input();
    boolean save(Customer customer);
    
    List<Customer> findAll();
}
