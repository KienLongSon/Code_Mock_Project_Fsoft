package dao.impl;

import dao.CustomerDAO;
import model.Address;
import model.Customer;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean saveNewCustomer(Customer customer) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "INSERT INTO CUSTOMER(FULL_NAME, EMAIL, PHONE_NUMBER, ADDRESS_ID) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setInt(4, customer.getAddressId());
            
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return id>0;
            }
            return preparedStatement.executeUpdate()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        return false;
    }

    @Override
    public List<Customer> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM CUSTOMER";
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            List<Customer> customers =new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("CUSTOMER_ID");
                String fullName = resultSet.getString("FULL_NAME");
                String email = resultSet.getString("EMAIL");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                int addressId = resultSet.getInt("ADDRESS_ID");
                
                customers.add(new Customer(id, fullName, email, phoneNumber, addressId));
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        
    }

    @Override
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM CUSTOMER WHERE PHONE_NUMBER =" + "\'" + phoneNumber + "\'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            return new Customer(resultSet.getInt("CUSTOMER_ID"),
                    resultSet.getString("FULL_NAME"),
                    resultSet.getString("EMAIL"),
                    resultSet.getString("PHONE_NUMBER"),
                    resultSet.getInt("ADDRESS_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean updateCustomerById(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "UPDATE ";
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean saveNewAddress(Address address) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "INSERT INTO ADDRESS(DISTRICT, SUB_DISTRICT, POSTAL_CODE, DELIVERY_FEE) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, address.getDistrict());
            preparedStatement.setString(2, address.getSubDistrict());
            preparedStatement.setString(3, address.getPostalCode());
            preparedStatement.setFloat(4, address.getDeliveryFee());
        
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return id>0;
            }
            return preparedStatement.executeUpdate()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public List<Address> findAllAddress() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ADDRESS";
        
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        
            List<Address> addresses =new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("ADDRESS_ID");
                String district = resultSet.getString("DISTRICT");
                String subDistrict = resultSet.getString("SUB_DISTRICT");
                String postalCode = resultSet.getString("POSTAL_CODE");
                float addressId = resultSet.getFloat("DELIVERY_FEE");
    
                addresses.add(new Address(id, district, subDistrict, postalCode, addressId));
            }
            return addresses;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    @Override
    public Address findAddressByPostalCode(String postalCode) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ADDRESS WHERE POSTAL_CODE =" + "\'" + postalCode + "\'";
        
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        
            return new Address(resultSet.getInt("ADDRESS_ID"),
                    resultSet.getString("DISTRICT"),
                    resultSet.getString("SUB_DISTRICT"),
                    resultSet.getString("POSTAL_CODE"),
                    resultSet.getFloat("DELIVERY_FEE"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
