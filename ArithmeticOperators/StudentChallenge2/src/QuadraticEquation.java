import java.util.*;

public class QuadraticEquation {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the values of a, b and c respectively: ");
    	
    	double a = sc.nextDouble();
    	double b = sc.nextDouble();
    	double c = sc.nextDouble();
    	
    	double D = b * b - 4 * a * c;
        
    	if(D >= 0) {
    	   double root1 = (-1 * b + Math.sqrt(D)) / (2 * a);
    	   double root2 = (-1 * b - Math.sqrt(D)) / (2 * a);
    	   System.out.println("Roots of the equation " + a + "x^2 + " + b + 
    			   "x + " + c + " = 0 are " + root1 + " and " + root2);
    	}
    	else {
    		System.out.println("No real roots exist!");
    	}
    	
    	sc.close();
    }
}
