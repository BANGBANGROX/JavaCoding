import java.util.*;

public class Challenge1Question3 {
   static int maxElement (int a[], int n) {
	   int maxValue = a[0];
	   
	   for (int i = 1; i < n; ++i) {
		   if (a[i] > maxValue) maxValue = a[i];
	   }
	   
	   return maxValue;
   }
   
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int n = sc.nextInt();
	   int a[] = new int[n];
	   
	   for (int i = 0; i < n; ++i) {
		   a[i] = sc.nextInt();
	   }
	   
	   int maxValue = maxElement(a, n);
	   
	   System.out.println("Max Element in the array is " + maxValue);
	   
	   sc.close();
   }
}
