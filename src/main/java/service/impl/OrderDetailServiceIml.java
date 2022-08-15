package service.impl;

import dto.ProductDto;
import model.OrderDetail;
import model.Product;
import service.OrderDetailSerive;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDetailServiceIml implements OrderDetailSerive {
    private ProductService productService = new ProductServiceImpl();
    @Override
    public List<OrderDetail> createOrderDetail(int orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        System.out.println("Enter OrderDetail...");
        boolean check = false;
        do {
            System.out.println("Enter product order");
            System.out.print("Quantity: ");
            int quantity =Integer.parseInt( new Scanner(System.in).nextLine());
            System.out.print("Product Id: ");
            int productID =Integer.parseInt( new Scanner(System.in).nextLine());
            ProductDto product = productService.getProductById(productID);
            Double total = Double.valueOf(product.getPrice()*product.getDiscountPrice()*quantity);
            orderDetails.add(new OrderDetail(quantity, total, orderId, productID));
            System.out.print("Do you want to continue? (Y/N)");
            if ((new Scanner(System.in).nextLine()).equals("Y")){
                check = true;
            }else {
                check=false;
            }
        }while (check);
        return orderDetails;
    }
}
