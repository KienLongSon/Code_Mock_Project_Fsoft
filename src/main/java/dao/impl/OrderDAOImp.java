package dao.impl;

import dao.OrderDAO;
import model.Discount;
import model.Order;
import model.OrderDetail;
import util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImp implements OrderDAO {
    @Override
    public Discount findDiscountById(int discountId) {
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM DISCOUNT WHERE DISCOUNT_ID = " + discountId;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String startDate = resultSet.getString("START_DATE");
            String endDate = resultSet.getString("END_DATE");
            return new Discount(resultSet.getInt("DISCOUNT_ID"),
                    resultSet.getString("TITLE"),
                    resultSet.getString("TYPE"),
                    resultSet.getFloat("DISCOUNT"),
                    LocalDate.parse(startDate, dateTimeFormatter),
                    LocalDate.parse(endDate, dateTimeFormatter));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getFinalIdOrder() {
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ORDER ORDER BY ID DESC LIMIT 1";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            return resultSet.getInt("ORDER_ID");

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }



    @Override
    public int saveOrder(Order order) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "INSERT INTO ORDER(NAME, PHONE_NUMBER, DETAIL_ADDRESS, TOTAL, ORDER_DATE, " +
                    "CUSTOMER_ID, ADDRESS_ID, DISCOUNT_ID) VALUES (?,?, ?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, order.getPhoneNumber());
            preparedStatement.setString(3, order.getDetailAddress());
            preparedStatement.setDouble(4, order.getTotal());
            preparedStatement.setString(5, order.getOrderDate().toString());
            preparedStatement.setInt(6, order.getCustomerId());
            preparedStatement.setInt(7, order.getAddressId());
            preparedStatement.setInt(8, order.getDiscountId());
            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return id;
            }
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Order> findOrderByName(String nameCustomer) {
        List<Order> orderList = new ArrayList<>();
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ORDER WHERE FULL_NAME LIKE " + "\'%"+ nameCustomer +"%\'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while (resultSet.next()){
                orderList.add(new Order(resultSet.getInt("ORDER_ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PHONE_NUMBER"),
                        resultSet.getString("DETAIL_ADDRESS"),
                        resultSet.getDouble("TOTAL"),
                        LocalDate.parse(resultSet.getString("ORDER_DATE"), dateTimeFormatter),
                        resultSet.getInt("CUSTOMER_ID"),
                        resultSet.getInt("ADDRESS_ID"),
                        resultSet.getInt("DISCOUNT_ID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderByOrderDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderDate = LocalDate.parse(date, dateTimeFormatter);
        List<Order> orderList = new ArrayList<>();

        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ORDER WHERE ORDER_DATE = "+"\'" + orderDate + "\' ORDER BY ORDER_ID ASC ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                orderList.add(new Order(resultSet.getInt("ORDER_ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PHONE_NUMBER"),
                        resultSet.getString("DETAIL_ADDRESS"),
                        resultSet.getDouble("TOTAL"),
                        LocalDate.parse(resultSet.getString("ORDER_DATE"), dateTimeFormatter),
                        resultSet.getInt("CUSTOMER_ID"),
                        resultSet.getInt("ADDRESS_ID"),
                        resultSet.getInt("DISCOUNT_ID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderList;
    }

    @Override
    public List<Order> getOrderTodaySortMoney() {
        List<Order> orderList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderDate = java.time.LocalDate.parse("yyyy-MM-dd");
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ORDER WHERE ORDER_DATE = "+"\'" + orderDate + "\' ORDER BY TOTAL ASC ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                orderList.add(new Order(resultSet.getInt("ORDER_ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PHONE_NUMBER"),
                        resultSet.getString("DETAIL_ADDRESS"),
                        resultSet.getDouble("TOTAL"),
                        LocalDate.parse(resultSet.getString("ORDER_DATE"), dateTimeFormatter),
                        resultSet.getInt("CUSTOMER_ID"),
                        resultSet.getInt("ADDRESS_ID"),
                        resultSet.getInt("DISCOUNT_ID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderList;
    }

    @Override
    public int removeOrder(int orderId) {
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "DELETE FROM ORDER WHERE ORDER_ID = " + orderId;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.getResultSet();
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Order findOrderByID(int orderID) {
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ORDER WHERE ORDER_ID = " + "\'"+ orderID +"\'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            return new Order(resultSet.getInt("ORDER_ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PHONE_NUMBER"),
                        resultSet.getString("DETAIL_ADDRESS"),
                        resultSet.getDouble("TOTAL"),
                        LocalDate.parse(resultSet.getString("ORDER_DATE"), dateTimeFormatter),
                        resultSet.getInt("CUSTOMER_ID"),
                        resultSet.getInt("ADDRESS_ID"),
                        resultSet.getInt("DISCOUNT_ID"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
