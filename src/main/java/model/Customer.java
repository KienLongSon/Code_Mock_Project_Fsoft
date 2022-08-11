package model;

public class Customer {
    private int customerId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private int addressId;
    
    public Customer() {
    }
    
    public Customer(int customerId, String fullName, String email, String phoneNumber, int addressId) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getAddressId() {
        return addressId;
    }
    
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressId=" + addressId +
                '}';
    }

}
