package dao;

import model.Address;
import model.Customer;

import java.util.List;

public interface CustomerDAO {
    boolean saveNewCustomer(Customer customer);
    
    List<Customer> findAll();
    Customer findCustomerByPhoneNumber(String phoneNumber);
    
    boolean updateCustomer(Customer customer);
    
    
    boolean saveNewAddress(Address address);
    
    List<Address> findAllAddress();
    
    Address findAddressByPostalCode(String postalCode);
}
