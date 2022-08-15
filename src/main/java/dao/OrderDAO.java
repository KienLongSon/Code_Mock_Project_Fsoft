package dao;

import model.Discount;
import model.Order;
import model.OrderDetail;

import java.util.List;

public interface OrderDAO {
    Discount findDiscountById(int discountId);
    int getFinalIdOrder();
//    int saveOrderDetail(List<OrderDetail> orderDetails);
    int saveOrder(Order order);
    List<Order> findOrderByName(String nameCustomer);
    List<Order> getOrderByOrderDate(String date);
    List<Order> getOrderTodaySortMoney();
    int removeOrder(int orderId);
    Order findOrderByID(int orderID);
//    int saveOrder(Order order);
}
