import java.util.*;

public class Challenge2Question3 {
     public static void main(String args[]) {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 System.out.println("Enter your date: ");
    	 String date = sc.next();
    	 
    	 System.out.println(date.matches("[0-3][0-2]/[01][0-9]/[0-9]{4}"));
         
    	 sc.close();
     }
}
