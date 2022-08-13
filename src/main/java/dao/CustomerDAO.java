package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    boolean save(Customer customer);
    
    List<Customer> findAll();
    Customer findCustomerByPhoneNumber(String phoneNumber);
}
