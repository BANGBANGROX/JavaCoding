import java.util.*;

public class Challenge3Question1 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int num = sc.nextInt();
	   String inWords = "";
	   
	   while (num > 0) {
		   int digit = num % 10;
		   String word = "";
		   switch(digit) {
		   case 0 : word = "zero";
				    break;
		   case 1 : word = "one";
				    break;
		   case 2 : word = "two";
		   		    break;
		   case 3 : word = "three";
		   			break;
		   case 4 : word = "four";
		   			break;
		   case 5 : word = "five";
		   			break;
		   case 6 : word = "six";
		   			break;
		   case 7 : word = "seven";
		   			break;
		   case 8 : word = "eight";
		   			break;
		   case 9 : word = "nine";
		   			break;
		   default : word = " ";
		   			 break;
		   }
		   inWords = word + " " + inWords;
		   num /= 10;
	   }
	   
	   System.out.println(inWords);
	   
	   sc.close();
   }
}
