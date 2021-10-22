import java.util.*;

public class Challenge2Question4 {
   public static void main (String args[]) {
	    Scanner sc = new Scanner(System.in);
 	   
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	a[i] = sc.nextInt();
	    }
	    
	    int index = sc.nextInt();
        
	    for (int i = index + 1; i < n; ++i) {
	    	a[i - 1] = a[i];
	    }
	    
	    --n;
	    
	    System.out.println("Array after deleting element at index " + index + " is: ");
	    
	    for (int i = 0; i < n; ++i) {
	       System.out.print(a[i] + " ");	
	    }
	    
	    sc.close();	    
   }
}
