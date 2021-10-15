import java.util.*;

public class Challenge1Question1 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter an integer: ");
	   int num = sc.nextInt();
	   
	   if (num % 2 == 1) {
		  System.out.println("Odd number"); 
	   }
	   else {
		   System.out.println("Even number");   
	   }
	   
	   sc.close();
   }
}
