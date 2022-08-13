package service.impl;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import model.Customer;
import model.Order;
import service.OrderService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderServiceImp implements OrderService {

    private static List<Order> orderList = new ArrayList<>();
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Order createOrder() {
        System.out.print("Phone Customer: ");
        String phoneNumber = scanner.nextLine();
        /**
         * Get data customer by phoneNumber (if exist),
         * Or create new customer if non exist
         */
        Customer customer = new Customer();
        if(customerDAO.findCustomerByPhoneNumber(phoneNumber) != null){
            customer = customerDAO.findCustomerByPhoneNumber(phoneNumber);
        }else {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Detail Address: ");
            String detailAddress = scanner.nextLine();
        }
        LocalDate orderDate = java.time.LocalDate.now();
        System.out.print("AddressID: ");
        int addressId = Integer.parseInt(scanner.nextLine());
        System.out.print("DiscountID: ");
        int discountID = Integer.parseInt(scanner.nextLine());
        float discount = 0;
        String startDate = "2022-01-02", endDate= "2023-01-02";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(LocalDate.parse(startDate, dateTimeFormatter).isBefore(orderDate)
            && LocalDate.parse(endDate, dateTimeFormatter).isAfter(orderDate)){

        }
        return null;
    }

    @Override
    public List<Order> searchOrderByName() {
        return null;
    }

    @Override
    public void showOrderByDate() {

    }

    @Override
    public void showOrderTodayByTotalMoney() {

    }

    @Override
    public boolean removeOrder() {
        return false;
    }

    @Override
    public boolean editOrder() {
        return false;
    }

    @Override
    public void showOrderDetail() {

    }
}
