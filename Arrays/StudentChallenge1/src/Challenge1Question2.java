import java.util.*;

public class Challenge1Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int n = sc.nextInt();
	   int k = sc.nextInt();
	   int a[] = new int[n];
	   
	   for (int i = 0; i < n; ++i) {
		   a[i] = sc.nextInt();
	   }
	   
	   boolean found = false;
	   
	   for (int i = 0; i < n; ++i) {
		  if(a[i] == k) {
			  System.out.println("Element found at index " + i);
			  found = true;
			  break;
		  }
	   }
	   
	   if (!found) {
		   System.out.println("Element not found");
	   }
	   
	   sc.close();   
   }
}
