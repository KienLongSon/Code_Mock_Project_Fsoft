package dao;

import model.Product;

import java.util.List;

public interface ProductDao {
    boolean addProduct(Product product);
    Product getProductById(int id);
    Product getProductByName(String name);
    List<Product> getAllProduct();
    boolean updateProduct(Product product);
    boolean deleteProductById(int id);
}
