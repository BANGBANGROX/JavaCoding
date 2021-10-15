import java.util.*;

public class Challenge3Question1 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter a day number: ");
	   int dayNum = sc.nextInt();
	   
	   String day = "Invalid Day Number!!!";
	   
	   if (dayNum == 1) day = "Monday";
	   else if (dayNum == 2) day = "Tuesday";
	   else if (dayNum == 3) day = "Wednesday";
	   else if (dayNum == 4) day = "Thursday";
	   else if (dayNum == 5) day = "Friday";
	   else if (dayNum == 6) day = "Saturday";
	   else if (dayNum == 7) day = "Sunday";
	   
	   System.out.println(day);
	   
	   sc.close();   
   }
}
