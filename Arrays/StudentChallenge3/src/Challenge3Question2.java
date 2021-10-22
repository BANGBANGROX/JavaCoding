import java.util.*;

public class Challenge3Question2 {
   public static void main (String args[]) {
	    Scanner sc = new Scanner(System.in);
 	   
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	a[i] = sc.nextInt();
	    }
	    
	    int reverseCopy[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	reverseCopy[i] = a[n - i - 1];
	    }
	    
	    System.out.println("Reverse copy of array is: ");
	    
	    for (int i = 0; i < n; ++i) {
	       System.out.print(reverseCopy[i] + " ");
	    }
	    
	    sc.close();
   }
}
