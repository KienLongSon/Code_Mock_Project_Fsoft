package util;

public class Validator {
    private static Validator instance;
    
    public static Validator getInstance() {
        return instance = instance != null ? instance : new Validator();
    }
    
    
}
