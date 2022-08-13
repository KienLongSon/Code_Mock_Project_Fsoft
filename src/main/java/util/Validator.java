package util;

import java.util.Scanner;

public class Validator {
    private final Scanner scanner = new Scanner(System.in);
    private static Validator instance;
    
    public static Validator getInstance() {
        return instance = instance != null ? instance : new Validator();
    }


    /**
    Validate Customer
     */
    public String ValidatePhoneNumber(){
        String phoneNumber = scanner.nextLine();
        String reg = "^((\\+84)|0)\\d{9}$";
        if (phoneNumber.matches(reg)){
            return phoneNumber;
        }
        System.out.println("Enter phone number again: ");
        return ValidatePhoneNumber();
    }
    
    public String ValidatePostalCode(){
        String postalCode = scanner.nextLine();
        String reg = "^\\d{6}$";
        if (postalCode.matches(reg)){
            return postalCode;
        }
        System.out.println("Enter postal code again: ");
        return ValidatePostalCode();
    }

    /** Validate Order.
     */

    public boolean validatePhoneExist(String phoneNumber){
        return false;
    }


}
