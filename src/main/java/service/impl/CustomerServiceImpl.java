package service.impl;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import model.Address;
import model.Customer;
import service.CustomerService;
import util.Validator;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Customer create() {
        List<Customer> customers = findAll();
        if (customers == null){
            System.out.println("No customer yet!!");
        }else {
            Customer customer = new Customer();
            System.out.println("Enter customer id: ");
            int customerId = scanner.nextInt();
            scanner.nextLine();
            List<Customer> customerFilter =customers.stream()
                    .filter(customer1 -> Objects.equals(customer1.getCustomerId(), customerId))
                    .collect(Collectors.toList());
            if (customerFilter.size()==0){
                customer.setCustomerId(customerId);
                System.out.println("Enter customer full name: ");
                customer.setFullName(scanner.nextLine());
                System.out.println("Enter customer email: ");
                customer.setEmail(Validator.getInstance().ValidateEmail());
                System.out.println("Enter customer phone number: ");
                String phoneNumber = Validator.getInstance().ValidatePhoneNumber();
                if(customerDAO.findCustomerByPhoneNumber(phoneNumber) != null){
                    System.out.println("This phone number is existed. Pls enter again! ");
                    return create();
                }else {
                    customer.setPhoneNumber(phoneNumber);
                    System.out.println("Enter address postal code: ");
                    String postalCode = scanner.nextLine();
                    Address address = new Address();
                    List<Address> addresses = findAllAddress();
                    if (checkAddressPostalCode(postalCode) == false){
                        address = createAddress();
                        addresses.add(address);
                        if (saveAddress(address) == true){
                            return customer;
                        }
                    }else {
                        System.out.println("Address is existed!!!");
                        int newAddressId;
                        newAddressId = addresses.stream()
                                .filter(newAddress -> Objects.equals(newAddress.getPostalCode(), postalCode))
                                .collect(Collectors.toList())
                                .get(0).getAddressId();
                        customer.setAddressId(newAddressId);
                        return customer;
                    }
                    
                }
            } else {
                System.out.println("Customer id is existed, please enter again! ");
                return create();
            }
        }
        return null;
    }
    
    @Override
    public boolean saveCustomer(Customer customer) {
        return customerDAO.saveNewCustomer(customer);
    }
    
    
    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }
    
    @Override
    public String updateCustomerById(int id) {
        return null;
    }
    
    
    @Override
    public void showAllCustomer() {
        List<Customer> customers = findAll();
        customers.forEach(System.out::println);
    }
    
    @Override
    public Address createAddress() {
        System.out.println("Enter address postal code: ");
        String postalCode = scanner.nextLine();
        Address address = new Address();
        if (checkAddressPostalCode(postalCode) == false){
            
            address.setPostalCode(postalCode);
            System.out.println("Enter district: ");
            address.setDistrict(scanner.nextLine());
            System.out.println("Enter sub-district: ");
            address.setSubDistrict(scanner.nextLine());
            address.setDeliveryFee(30000);
        }else {
            System.out.println("Address id is existed!!!");
            return createAddress();
        }
        return address;
    }
    
    @Override
    public boolean saveAddress(Address address) {
        return customerDAO.saveNewAddress(address);
    }
    
    @Override
    public List<Address> findAllAddress() {
        return customerDAO.findAllAddress();
    }
    
    @Override
    public boolean checkAddressId(int addressId) {
        List<Address> addresses = findAllAddress();
        List<Address> addresseFilter = addresses.stream()
                .filter(address -> Objects.equals(address.getAddressId(), addressId))
                .collect(Collectors.toList());
        if (addresseFilter.size() == 0){
            return false;
        }else {
            return false;
        }
        
    }
    
    @Override
    public boolean checkAddressPostalCode(String postalCode) {
        List<Address> addresses = findAllAddress();
        List<Address> addressFilter = addresses.stream()
                .filter(address -> Objects.equals(address.getPostalCode(), postalCode))
                .collect(Collectors.toList());
        if (addressFilter.size() == 0){
            return false;
        }
        return true;
    }
}
