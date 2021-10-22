import java.util.*;

public class Challenge3Question1 {
   public static void main (String args[]) {
	    Scanner sc = new Scanner(System.in);
 	   
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	a[i] = sc.nextInt();
	    }
	    
	    int copy[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	copy[i] = a[i];
	    }
	    
	    System.out.println("Copied array is: ");
	    
	    for (int i = 0; i < n; ++i) {
	    	System.out.print(copy[i] + " ");
	    }
	    
	    sc.close();
   }
}
