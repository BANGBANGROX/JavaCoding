import java.util.*;

public class Challenge1Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter the value of n: ");
	   int n = sc.nextInt();
	   
	   int sum = 0;
	   for (int i = 1;i <= n; ++i) sum += i;
	   
	   System.out.println("Sum of first " + n + " natural numbers is: " + sum);
	   
	   sc.close();
   }
}
