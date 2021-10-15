import java.util.*;

public class Challenge2Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter your year: ");
	   int year = sc.nextInt();
	   
	   if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
		   System.out.println("You entered a leap year!");
	   }
	   else {
		   System.out.println("You entered an ordinary year :(");
	   }
	   
	   sc.close();
   }
}
