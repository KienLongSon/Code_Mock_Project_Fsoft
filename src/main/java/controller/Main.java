package controller;

import model.Order;
import org.w3c.dom.ls.LSOutput;
import service.CustomerService;
import service.OrderService;
import service.impl.CustomerServiceImpl;
import service.impl.OrderServiceImp;

import java.util.List;
import java.util.Scanner;

public class Main {
    
    private final static Scanner scanner = new Scanner(System.in);
    
    private final static CustomerService customerService = new CustomerServiceImpl();
    private static OrderService orderService = new OrderServiceImp();
    
    public static void main(String[] args) {
        int menu;
        do{
            menu = mainMenu();
            switch (menu){
                case 1:{
                    int subMenuCustomer = subMenuCustomer();
                    switch (subMenuCustomer){
                        case 1:{
                            boolean result = customerService.saveCustomer(customerService.create());
                            if (result == true){
                                System.out.println("Create a new customer successful!!");
                            }else {
                                System.out.println("No success");
                            }
                            break;
                        }
                        case 2:{
                            System.out.println(customerService.updateCustomerById());
                            break;
                        }
                        case 3: {
                            System.out.println("List of customers: ");
                            customerService.showAllCustomer();
                        }
                        default: break;
                    }
                    break;
                }
                case 2:{
                    int subMenuProduct = subMenuProduct();
                    switch (subMenuProduct){
                        case 1:{
                            
                            break;
                        }
                        case 2:{
                            
                            break;
                        }
                        case 3:{
                            
                            break;
                        }
                        default: break;
                    }
                    break;
                }
                case 3:{
                    int subMenuOrder = MenuOrder.getInstance().MainMenuOrder();
                    switch (subMenuOrder){
                        case 1:{
                            if (orderService.createOrder()>0){
                                System.out.println("Complete!");
                            }else System.out.println("Create fail");
                            break;
                        }
                        case 2:{
                            List<Order> orderList = orderService.searchOrderByName();
                            orderList.forEach(System.out::println);
                            int chooseOrderSearch = 0;
                            do {
                                chooseOrderSearch = MenuOrder.getInstance().MenuSearch();
                                switch (chooseOrderSearch){
                                    case 1:
                                        System.out.println("Id order view: ");
                                        orderService.showOrderDetail(Integer.parseInt(scanner.nextLine()));
                                        break;
                                    case 2:
                                        System.out.printf("Id order Edit:");
                                        orderService.editOrder(Integer.parseInt(scanner.nextLine()));
                                        break;
                                    case 3:
                                        System.out.println("Id order delete:");
                                        orderService.removeOrder(Integer.parseInt(scanner.nextLine()));
                                        break;
                                    case 0:
                                        chooseOrderSearch=0;
                                        break;
                                    default:
                                        break;
                                }
                            }while (chooseOrderSearch!=0);
                            break;
                        }
                        case 3:{
                            orderService.showOrderByDate();
                            break;
                        }
                        case 4:
                            orderService.showOrderTodayByTotalMoney();
                            break;
                        default: break;
                    }
                }
                
                case 4:{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("You must input 1, 2 or 3");
                }
            }
        } while (true);
        
    }
    
    private static int mainMenu(){
        System.out.println("---------Main menu----------");
        System.out.println("1. Customer menu");
        System.out.println("2. Product menu");
        System.out.println("3. Order menu");
        System.out.println("4. Exit");
        System.out.println("Enter your choose: ");
        int chooseMainMenu;
        chooseMainMenu = scanner.nextInt();
        return chooseMainMenu;
    }
    
    private static int subMenuCustomer(){
        System.out.println("---------Customer menu----------");
        System.out.println("1. Add a new customer");
        System.out.println("2. Update a customer by id");
        System.out.println("3. Show all customers");
        System.out.println("4. Exit");
        System.out.println("Enter your choose: ");
        int chooseSubMenuCustomer;
        chooseSubMenuCustomer = scanner.nextInt();
        return chooseSubMenuCustomer;
    }
    
    private static int subMenuProduct(){
        System.out.println("---------Product menu----------");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("Enter your choose: ");
        int chooseSubMenuProduct;
        chooseSubMenuProduct = scanner.nextInt();
        return chooseSubMenuProduct;
    }
    
    private static int subMenuOrder(){
        System.out.println("---------Order menu----------");
        System.out.println(
                "1. Create new Order:\n" +
                "2. Search order by Name customer.\n" +
                "3. List order by Date.\n" +
                "4. List order by Total Money.\n" +
                "0. Back to Main Menu Shop....");
        int chooseSubMenuOrder;
        chooseSubMenuOrder = scanner.nextInt();
        return chooseSubMenuOrder;
    }
    
    
}
