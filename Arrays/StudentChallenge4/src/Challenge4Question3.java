import java.util.*;

public class Challenge4Question3 {
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int n = sc.nextInt();
	   String arr[] = new String[n];
	   
	   for (int i = 0; i < n; ++i) {
		   arr[i] = sc.next();
	   }
	   
	   Arrays.sort(arr);
	   
	   System.out.println("Sorted array is: ");
	   
	   for (int i = 0; i < n; ++i) {
	       System.out.print(arr[i] + " ");	   
	   }
	   
	   sc.close();
   }
}
