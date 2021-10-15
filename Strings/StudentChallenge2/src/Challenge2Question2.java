import java.util.*;

public class Challenge2Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter your number: ");
	   String num = sc.next();
	   
	   System.out.println(num.matches("[0-9A-Fa-f]+"));
	   
	   sc.close();
   }
}
