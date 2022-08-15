package model;

import java.time.LocalDate;
import java.util.Date;

/*1 customer create 1 order, in order init list orderDetail -
* is list product order.*/
public class Order {
    private int orderId;
    private String name;
    private String  phoneNumber;
    private String detailAddress;
    private Double total;
    private LocalDate orderDate;
    private int customerId;
    private int addressId;
    private int discountId;

    public Order(String name, String phoneNumber, String detailAddress, double total, LocalDate orderDate, int customerId, int addressId, int discountId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.addressId = addressId;
        this.discountId = discountId;
    }

    public Order(int orderId, String name, String phoneNumber, String detailAddress, double total, LocalDate orderDate, int customerId, int addressId, int discountId) {
        this.orderId = orderId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.addressId = addressId;
        this.discountId = discountId;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }
}
