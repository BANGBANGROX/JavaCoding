import java.util.*;

public class Challenge2Question2 {
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
 	   
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	a[i] = sc.nextInt();
	    }
	    
	    int temp = a[n - 1];
	    
	    for (int i = n - 2; i >= 0; --i) {
	    	a[i + 1] = a[i];
	    }
	    
	    a[0] = temp;
	    
	    System.out.println("Array after right rotation: ");
	    
	    for (int i = 0; i < n; ++i) {
	    	System.out.print(a[i] + " ");
	    }
	    
	    sc.close();
   }
}
