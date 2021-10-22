import java.util.*;

public class Challenge1Question4 {
    public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
  	   
 	    int n = sc.nextInt();
 	    int a[] = new int[n];
 	    
 	    for (int i = 0; i < n; ++i) {
 	    	a[i] = sc.nextInt();
 	    }
 	    
 	    int maxElement = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, maxIndex = -1,
 	    		secondMaxIndex = -1;
 	    
 	    for (int i = 0; i < n; ++i) {
 	    	if (a[i] > maxElement) {
 	    		secondMax = maxElement;
 	    		secondMaxIndex = maxIndex;
 	    		maxElement = a[i];
 	    		maxIndex = i;
 	    	}
 	    	else if (a[i] > secondMax && a[i] <= maxElement) {
 	    		secondMax = a[i];
 	            secondMaxIndex = i;      		
 	    	}
 	    }
 	    
 	    System.out.println("Second max element = " + secondMax + " found at index " + 
 	    secondMaxIndex);
 	    
 	    sc.close();
    }
}
