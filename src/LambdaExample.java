public class LambdaExample {
    public static void main(String[] args) {
    	
        // A lambda expression to check if a number is even
        NumberChecker check = (n) -> n % 2 == 0;

        
        // Calling the lambda expression
        boolean isEven = check.checkNumber(7);

       
        System.out.println(isEven);
    }
}

// Functional interface with a lambda expression

interface NumberChecker {
    boolean checkNumber(int n);
}
