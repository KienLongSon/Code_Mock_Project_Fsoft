package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
    
    public String ValidateEmail(){
        String email = scanner.nextLine();
        String reg = "^(.+)@(\\S+) $";
        if (email.matches(reg)){
            return email;
        }
        System.out.println("Enter email again: ");
        return ValidateEmail();
    }
    /**
     Validate Address
     */
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

    public boolean validateLocalDate(String date){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date,dateTimeFormatter);
        }catch (Exception e){
            return false;
        }
        return true;
    }


}
