import java.util.*;

public class Challenge1Question2 {
    static int findGCD (int a, int b) {
    	while (b != 0) {
    		int rem = a % b;
    		a = b;
    		b = rem;
    	}
    	
    	return a;
    }
    
    public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	
    	int gcd = findGCD(a, b);
    	
    	System.out.println("GCD of " + a + " and " + b + " is " + gcd);
    	
    	sc.close();
    }
}
