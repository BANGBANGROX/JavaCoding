import java.util.*;

public class Challenge2Question1 {
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
 	   
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	a[i] = sc.nextInt();
	    }
	    
	    int temp = a[0];
	    
	    for (int i = 1; i < n; ++i) {
	    	a[i - 1] = a[i];
	    }
	    
	    a[n - 1] = temp;
	    
	    System.out.println("Array after left rotation: ");
	    
	    for (int i = 0; i < n; ++i) {
	        System.out.print(a[i] + " ");	
	    }
	    
	    sc.close();
   }
}
