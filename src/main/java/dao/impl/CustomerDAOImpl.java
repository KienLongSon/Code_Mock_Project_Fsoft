package dao.impl;

import dao.CustomerDAO;
import model.Customer;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
