import java.util.*;

public class Challenge2Question3 {
   public static void main (String args[]) {
	    Scanner sc = new Scanner(System.in);
 	   
	    int maxSize = (int)1e6 + 5;
	    int a[] = new int[maxSize];
	    int n = sc.nextInt();
	    
	    for (int i = 0; i < n; ++i) {
	    	a[i] = sc.nextInt();
	    }
	    
	    int k = sc.nextInt();
	    int index = sc.nextInt();
        
	    for (int i = n - 1; i >= index; --i) {
	    	a[i + 1] = a[i];
	    }
	    
	    a[index] = k;
	    ++n;
	    
	    System.out.println("Array after inserting " + k + " is: ");
	    
	    for (int i = 0; i < n; ++i) {
	    	System.out.print(a[i] + " ");
	    }
	    
	    sc.close();    
   }
}
