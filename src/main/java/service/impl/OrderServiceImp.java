package service.impl;

import controller.MenuOrder;
import dao.CustomerDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.impl.CustomerDAOImpl;
import dao.impl.OrderDAOImp;
import dao.impl.OrderDetailDAOImp;
import model.Customer;
import model.Discount;
import model.Order;
import model.OrderDetail;
import service.OrderDetailSerive;
import service.OrderService;
import util.Validator;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OrderServiceImp implements OrderService {

    private static List<Order> orderList = new ArrayList<>();
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImp();
    private OrderDetailSerive orderDetailSerive = new OrderDetailServiceIml();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImp();
    private Scanner scanner = new Scanner(System.in);
    @Override
    public int createOrder() {
        System.out.print("Phone Customer: ");
        String phoneNumber = scanner.nextLine();
        /**
         * Get data customer by phoneNumber (if exist),
         * Or create new customer if non exist
         */
        Customer customer = new Customer();
        String detailAddress = null;
        if(!Objects.isNull(customerDAO.findCustomerByPhoneNumber(phoneNumber))){
            customer = customerDAO.findCustomerByPhoneNumber(phoneNumber);
        }else {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            customer.setFullName(name);
            System.out.print("Detail Address: ");
            detailAddress = scanner.nextLine();
        }
        LocalDate orderDate = java.time.LocalDate.now();

        System.out.print("AddressID: ");
        int addressId = Integer.parseInt(scanner.nextLine());
        System.out.print("DiscountID: ");
        int discountID = Integer.parseInt(scanner.nextLine());

        /**
         * get Discount by discountID
         */
        float discount = 0;
        LocalDate startDate , endDate;
        if(Objects.isNull(orderDAO.findDiscountById(discountID))){
            System.out.println("Discount non exist!");
        }else {
            Discount discount1 = orderDAO.findDiscountById(discountID);
            startDate = discount1.getStartDate();
            endDate = discount1.getEndDate();
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if(startDate.isBefore(orderDate) || endDate.isAfter(orderDate)){
                System.out.println("The discount code is no longer valid");
            }else{
                discount = discount1.getDiscount();
            }
        }

        /**
         * get orderID final in SQL database
         */
        int orderId = orderDAO.getFinalIdOrder() + 1;

        /**
         * create orderDetail_ func from OrderDetailService
         */
        List<OrderDetail> orderDetails = orderDetailSerive.createOrderDetail(orderId);

        //Calculate total for each Order
        Double total= Double.valueOf(0);
        for (OrderDetail i: orderDetails){
            total += i.getTotal();
        }

        //Save to DB
        System.out.printf(""+orderDetailDAO.saveOrderDetail(orderDetails));
        Order order = new Order(customer.getFullName(), customer.getPhoneNumber(),
                detailAddress, total, orderDate, customer.getCustomerId(), addressId, discountID);
        orderList.add(order);
        return (orderDAO.saveOrder(order));
    }

    @Override
    public List<Order> searchOrderByName() {
        System.out.print("Enter name Customer: ");
        return orderDAO.findOrderByName(scanner.nextLine());
    }

    @Override
    public void showOrderByDate() {
        String orderDate = null;
        do {
            System.out.print("Enter Date (yyyy-MM-dd):");
            orderDate = scanner.nextLine();
        }while (Validator.getInstance().validateLocalDate(orderDate));
        orderDAO.getOrderByOrderDate(orderDate).forEach(System.out::println);
    }

    @Override
    public void showOrderTodayByTotalMoney() {
        System.out.println("View Order Today sort by Total Money(VND)");
        orderDAO.getOrderTodaySortMoney().forEach(System.out::println);
    }

    @Override
    public boolean removeOrder(int orderID) {
        return orderDAO.removeOrder(orderID)>0;
    }

    @Override
    public boolean editOrder(int orderID) {
        Order order = orderDAO.findOrderByID(orderID);
        List<OrderDetail> orderDetails = orderDetailDAO.getOrderDetailByOrderID(orderID);
        System.out.println(order);
        orderDetails.forEach(System.out::println);
        int choose = MenuOrder.getInstance().MenuEditOrder();
        do {
            switch (choose){
                case 1:
                    System.out.print("New id Address:");
                    order.setAddressId(Integer.parseInt(scanner.nextLine()));
                    break;
                case 0:
                    orderDAO.saveOrder(order);
                    orderDetailDAO.saveOrderDetail(orderDetails);
                    return true;
//                    break;
                default:
                    break;

            }
        }while (MenuOrder.getInstance().MenuEditOrder()!=0);
        return false;
    }


    @Override
    public void showOrderDetail(int orderID) {
        orderDetailDAO.getOrderDetailByOrderID(orderID).forEach(System.out::println);
    }
}
