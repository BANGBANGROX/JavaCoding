import java.util.*;

public class Challenge2Question1 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter a number: ");
	   int num = sc.nextInt();
	   
	   String numS = String.valueOf(num);
	   
	   System.out.println(numS.matches("[0-1]+"));
	   
	   sc.close();
   }
}
