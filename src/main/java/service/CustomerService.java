package service;

import model.Address;
import model.Customer;

import java.util.List;

public interface CustomerService {
    Customer create();
    boolean saveCustomer(Customer customer);
    
    List<Customer> findAll();
    
    String updateCustomerById(int id);
    
    
    void showAllCustomer();
    
    Address createAddress();
    boolean saveAddress(Address address);
    List<Address> findAllAddress();
    
    boolean checkAddressId(int addressId);
    
    boolean checkAddressPostalCode(String postalCode);
}
