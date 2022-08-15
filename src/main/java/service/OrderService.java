package service;

import model.Order;

import java.util.List;

public interface OrderService {
    int createOrder();
    List<Order> searchOrderByName();
    void showOrderByDate();
    void showOrderTodayByTotalMoney();
    boolean removeOrder(int orderID);
    boolean editOrder(int orderID);
    void showOrderDetail(int orderID);
}
