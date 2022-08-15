package service;

import model.OrderDetail;

import java.util.List;

public interface OrderDetailSerive {
    List<OrderDetail> createOrderDetail(int orderId);
}
