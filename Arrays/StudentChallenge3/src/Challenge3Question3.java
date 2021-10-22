import java.util.*;

public class Challenge3Question3 {
   public static void main (String args[]) {
	    Scanner sc = new Scanner(System.in);
 	   
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    
	    for (int i = 0; i < n; ++i) {
	    	a[i] = sc.nextInt();
	    }
	    
	    int newArray[] = new int[2 * n];
	    
	    for (int i = 0; i < n; ++i) {
	    	newArray[i] = a[i];
	    }
	    
	    a = newArray;
	    newArray = null;
	    
	    System.out.println("Array size increased to " + a.length);
	    
	    sc.close();
   }
}
