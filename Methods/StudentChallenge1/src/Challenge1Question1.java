import java.util.*;

public class Challenge1Question1 {
	
   static boolean isPrime (int num) {
	   
	   for (int i = 2; i * i <= num; ++i) {
		   if (num % i == 0) return false;
	   }
	   
	   return true;
   }
	
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int num = sc.nextInt();
	   
	   boolean result = isPrime(num);
	   
	   if (result) {
		   System.out.println("Prime Number");
	   }
	   else {
		   System.out.println("Not a Prime Number");
	   }
	   
	   sc.close();   
   }
}
