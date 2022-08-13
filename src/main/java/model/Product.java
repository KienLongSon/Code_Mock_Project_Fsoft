package model;

import java.sql.Timestamp;

public class Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private float discountPrice;
    private int stock;
    private int sold;
    private Timestamp createDate;
    private int status;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public float getDiscountPrice() {
        return discountPrice;
    }
    
    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getSold() {
        return sold;
    }
    
    public void setSold(int sold) {
        this.sold = sold;
    }
    
    public Timestamp getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
}
