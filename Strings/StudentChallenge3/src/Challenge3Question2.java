import java.util.*;

public class Challenge3Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter the string: ");
	   String str = sc.nextLine();
	   
	   String filtered = str.trim().replaceAll("\\s+", " ");
	   System.out.println("Filtered string is: " + filtered);
	   
	   sc.close();
   }
}
