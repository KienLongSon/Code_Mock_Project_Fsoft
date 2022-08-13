package dao.impl;

import dao.ProductDao;
import model.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final DBUtil dbUtil;
    
    public ProductDaoImpl(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }
    
    @Override
    public boolean addProduct(Product product) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = dbUtil.getConnection();
            StringBuilder builder = new StringBuilder();
            builder.append("");
        }catch (Exception e){
        
        }finally {
        
        }
        return false;
    }
    
    @Override
    public Product getProductById(int id) {
        return null;
    }
    
    @Override
    public Product getProductByName(String name) {
        return null;
    }
    
    @Override
    public List<Product> getAllProduct() {
        return null;
    }
    
    @Override
    public boolean updateProduct(Product product) {
        return false;
    }
    
    @Override
    public boolean deleteProductById(int id) {
        return false;
    }
}
