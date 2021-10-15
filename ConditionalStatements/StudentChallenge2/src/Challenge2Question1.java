import java.util.*;

public class Challenge2Question1 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter your number: ");
	   String num = sc.next();
	   
	   int radix = -1;
	   
	   if (num.matches("[01]+")) radix = 2;
	   else if (num.matches("[0-7]+")) radix = 8;
	   else if (num.matches("[0-9]+")) radix = 10;
	   else if(num.matches("[A-Fa-f0-9]+")) radix = 16;
	   
	   System.out.println(radix);
	   
	   sc.close();
   }
}
