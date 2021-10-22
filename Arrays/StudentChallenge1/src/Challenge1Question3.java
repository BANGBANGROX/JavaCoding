import java.util.*;

public class Challenge1Question3 {
    public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
 	   
 	    int n = sc.nextInt();
 	    int a[] = new int[n];
 	    
 	    for (int i = 0; i < n; ++i) {
 	    	a[i] = sc.nextInt();
 	    }
 	    
 	    int maxElement = Integer.MIN_VALUE, index = -1;
 	    
 	    for (int i = 0; i < n; ++i) {
 	    	if (a[i] > maxElement) {
 	    		maxElement = a[i];
 	    		index = i;
 	    	}
 	    }
 	    
 	    System.out.println("Max Element = " + maxElement + " found "
 	    		+ "at index " + index);
 	    
 	    sc.close();   
    }
}
