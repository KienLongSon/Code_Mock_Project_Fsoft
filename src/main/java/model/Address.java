package model;

public class Address {
    private int addressId;
    private String district;
    private String subDistrict;
    private String postalCode;
    private float deliveryFee;
    
    public Address() {
    }
    
    //constructor default
    public Address(int addressId, String district, String subDistrict, String postalCode, float deliveryFee) {
        this.addressId = addressId;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
        this.deliveryFee = deliveryFee;
    }
    
    //constructor ko co deliveryFee
    public Address(int addressId, String district, String subDistrict, String postalCode) {
        this.addressId = addressId;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
    }
    
    public int getAddressId() {
        return addressId;
    }
    
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    
    
    public String getDistrict() {
        return district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    public String getSubDistrict() {
        return subDistrict;
    }
    
    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public float getDeliveryFee() {
        return deliveryFee;
    }
    
    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", district='" + district + '\'' +
                ", subDistrict='" + subDistrict + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", deliveryFee=" + deliveryFee +
                '}';
    }
}
