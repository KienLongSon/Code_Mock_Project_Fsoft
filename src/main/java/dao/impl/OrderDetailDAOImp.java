package dao.impl;

import dao.OrderDetailDAO;
import model.OrderDetail;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDetailDAOImp implements OrderDetailDAO {
    @Override
    public List<OrderDetail> getOrderDetailByOrderID(int orderID) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ORDER_DETAIL WHERE ORDER_ID = " + orderID;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                orderDetails.add(new OrderDetail(resultSet.getInt("CART_ID"),
                        resultSet.getInt("QUANTITY"),
                        resultSet.getDouble("TOTAL"),
                        resultSet.getInt("ORDER_ID"),
                        resultSet.getInt("PRODUCT_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
    @Override
    public int saveOrderDetail(List<OrderDetail> orderDetails) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "INSERT INTO ORDER_DETAIL (QUANTITY, TOTAL, ORDER_ID, PRODUCT_ID) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = null;
            for (OrderDetail i: orderDetails){
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, i.getQuantity());
                preparedStatement.setDouble(2, i.getTotal());
                preparedStatement.setInt(3, i.getOrderId());
                preparedStatement.setInt(4, i.getProductId());

                ResultSet resultSet = preparedStatement.getResultSet();
            }
            return preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
