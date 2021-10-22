import java.util.*;

public class Challenge2Question2 {
   static int reverse (int num) {
	   int revNum = 0;
	   
	   while (num != 0) {
		   int dig = num % 10;
		   revNum = revNum * 10 + dig;
		   num /= 10;
	   }
	   
	   return revNum;
   }
   
   static int[]reverse(int a[], int n) {
	   int revArray[] = new int[n];
	   
	   for (int i = 0; i < n; ++i) {
	        revArray[i] = a[n - i - 1]; 	   
	   }
	   
	   return revArray;
   }
   
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("1. Reverse a number\n2. Reverse an array\nWhat do you want to choose?");
	   
	   int choice = sc.nextInt();
	   
	   if (choice == 1) {
		  System.out.println("Enter the number: ");
		  int num = sc.nextInt();
		  int revNum = reverse(num);
		  System.out.println("Reversed number: " + revNum);
	   }
	  else {
		  System.out.println("Enter the size of the array: ");
		  int n = sc.nextInt();
		  int a[] = new int[n];
		  System.out.println("Enter the array: ");
		  for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
		  int revArray[] = reverse(a, n);
		  System.out.println("Reversed array is: ");
		  for (int i = 0; i < n; ++i) {
			  System.out.print(revArray[i] + " ");
		  }
		  System.out.println("");
	  }
	  
	  sc.close();
   }
}
