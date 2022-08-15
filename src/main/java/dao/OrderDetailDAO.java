package dao;

import model.OrderDetail;

import java.util.List;

public interface OrderDetailDAO {
    List<OrderDetail> getOrderDetailByOrderID(int orderID);
    int saveOrderDetail(List<OrderDetail> orderDetails);
}
