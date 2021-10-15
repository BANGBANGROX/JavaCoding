import java.util.*;

public class Challenge5Question1 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Menu: " + "\n" + "1. Add\n2. Subtract\n"
	   		+ "3. Multiply\n4. Divide\n5. Modulo\nEnter two numbers: ");
	   double a = sc.nextDouble();
	   double b = sc.nextDouble();
	   System.out.println("Enter your choice: ");
	   int choice = sc.nextInt();
	   
	   double res = -1;
	   
	   switch(choice) {
	   case 1 : res = a + b;
	   			break;
	   case 2 : res = a - b;
	   			break;
	   case 3 : res = a * b;
	   			break;
	   case 4 : res = a / b;
	   			break;
	   case 5 : res = a % b;
	   			break;
	   default : res = -1;
	             break;
	   }
	   
	   if (res == -1) {
		   System.out.println("Invalid choice :(");
	   }
	   else {
		   System.out.println("Result = " + res);   
	   }
	   
	   sc.close();
   }
}
