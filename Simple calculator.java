import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
interface ICalculator {
    /**
    * Adds given two numbers
    * @param x first number
    * @param y second number
    * @return the sum of the two numbers
    */
    int add(int x, int y);
    /**
    * Divides two numbers
    * @param x first number
    * @param y second number
    * @return the division result
    */
    float divide(int x, int y) throws RuntimeException;

}

public class SimpleCalculator implements ICalculator {
	public int add(int x, int y) {
        return x + y;
    }
    
    public float divide(int x, int y) throws RuntimeException {
        if (y == 0) {
            throw new ArithmeticException("Error");
        }
        return (float) x / y;
    }
    public static void main(String[] args) {
    	
    	
        final int MIN = -(int) Math.pow(2, 20);  // -2^20
        final int MAX = (int) Math.pow(2, 20);   // 2^20

        Scanner INPUT = new Scanner(System.in); 
        SimpleCalculator calculator = new SimpleCalculator(); 
        
        System.out.print("");
        String input = INPUT.nextLine(); 
        
        // Remove parentheses and spaces
        input = input.replaceAll("[()\\s]", "");
        
        try {
            // Check if the operator is + or /
            if (input.contains("+")) {
                String[] parts = input.split("\\+");
                if (parts.length == 2) {
                    int x = Integer.parseInt(parts[0]); // x
                    int y = Integer.parseInt(parts[1]); // y
                  
                    if (x > MIN && x <= MAX && y > MIN && y <= MAX) {
                        int sum = calculator.add(x, y);  
                        System.out.println(sum); 
                    } else {
                        System.out.println("Error");
                    }
                } else {
                    System.out.println("Error");
                }
            } else if (input.contains("/")) {
                String[] parts = input.split("/");
                if (parts.length == 2) {
                    int x = Integer.parseInt(parts[0]); // x
                    int y = Integer.parseInt(parts[1]); // y
                   
                    if (x > MIN && x <= MAX && y > MIN && y <= MAX) {
                        try {
                            float result = calculator.divide(x, y);  
                            System.out.println(result); 
                        } catch (RuntimeException e) {
                            System.out.println("Error");
                        }
                    } else {
                        System.out.println("Error");
                    }
                } else {
                    System.out.println("Error");
                }
            } else {
                System.out.println("Error");
            }
        } catch (NumberFormatException e) {
            // Catch any format errors
            System.out.println("Error");
        } finally {
            INPUT.close(); 
        }
    }
}
