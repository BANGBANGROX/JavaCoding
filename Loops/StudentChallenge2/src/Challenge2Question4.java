import java.util.*;

public class Challenge2Question4 {
	public static void main(String args[]) {
		   Scanner sc = new Scanner(System.in);
		   
		   int num = sc.nextInt(), revNum = 0;
		   
		   while (num > 0) {
			   int digit = num % 10;
			   revNum = revNum * 10 + digit;
			   num /= 10;
		   }
		   
		   System.out.println("Reversed number = " + revNum);
		   
		   sc.close();
	   }
}
