import java.util.*;

public class SwapWithXOR {
	
   public static void main(String args[]) {
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("Enter two numbers a and b: ");
	  
	  int a = sc.nextInt();
	  int b = sc.nextInt();
	  
	  System.out.println("Before swap a = " + a + " and b = " + b);
	  
	  a = a ^ b;
	  b = a ^ b;
	  a = a ^ b;
	  
	  System.out.println("After swap a = " + a + " and b = " + b);
	  
	  sc.close();
   }
}
