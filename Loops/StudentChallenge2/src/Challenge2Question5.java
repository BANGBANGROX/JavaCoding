import java.util.*;

public class Challenge2Question5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		   
		   int num = sc.nextInt(), revNum = 0, temp = num;
		   
		   while (num > 0) {
			   int digit = num % 10;
			   revNum = revNum * 10 + digit;
			   num /= 10;
		   }
		   System.out.println(temp == revNum ? 
				   "Palindrome" : "Not a palindrome");
		   
		   sc.close();
	   }
}
