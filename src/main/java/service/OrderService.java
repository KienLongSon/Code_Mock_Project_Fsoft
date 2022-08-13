package service;

import model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder();
    List<Order> searchOrderByName();
    void showOrderByDate();
    void showOrderTodayByTotalMoney();
    boolean removeOrder();
    boolean editOrder();
    void showOrderDetail();
}
