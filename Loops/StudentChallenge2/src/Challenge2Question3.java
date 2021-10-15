import java.util.*;

public class Challenge2Question3 {
	public static void main(String args[]) {
		   Scanner sc = new Scanner(System.in);
		   
		   int num = sc.nextInt(), sumOfCubes = 0, temp = num;
		   
		   while (num > 0) {
			   int digit = num % 10;
			   sumOfCubes += digit * digit * digit;   
			   num /= 10;
		   }
		   
		   System.out.println(temp == sumOfCubes ? "Armstrong Number" :
			   "Not an armstrong number");
		   
		   sc.close();
	   }
}
