import java.util.*;

public class Challenge2Question1 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int num = sc.nextInt();
	   
	   while (num > 0) {
		   int digit = num % 10;
		   System.out.println(digit);
		   num /= 10;
	   }
	   
	   sc.close();
   }
}
