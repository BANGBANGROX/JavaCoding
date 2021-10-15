import java.util.*;

public class Challenge1Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
       System.out.println("Enter your age: ");
       int age = sc.nextInt();
       
       if (age >= 14 && age < 40) {
    	   System.out.println("You are young!");
       }
       else {
    	   System.out.println("You are not young!");
       }
       
       sc.close();
   }
}
