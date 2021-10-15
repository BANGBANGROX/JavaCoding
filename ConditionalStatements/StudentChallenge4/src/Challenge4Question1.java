import java.util.*;

public class Challenge4Question1 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter a day number: ");
	   int dayNum = sc.nextInt();
	   
	   String day = "Invalid day number";
	   
	   switch(dayNum) {
	   case 1 : day = "Monday";
	            break;
	   case 2 : day = "Tuesday";
	            break;
	   case 3 : day = "Wednesday";
	            break;
	   case 4 : day = "Thurday";
	            break;
	   case 5 : day = "Friday";
	   		    break;
	   case 6 : day = "Saturday";
	   			break;
	   case 7 : day = "Sunday";
	   			break;
	   }
	   
	   System.out.println(day);
	   
	   sc.close();
   }
}
