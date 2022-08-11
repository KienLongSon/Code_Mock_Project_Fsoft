package dao.impl;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) {
        return false;
    }
    
    @Override
    public List<Customer> findAll() {
        return null;
    }
}
