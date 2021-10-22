
public class Challenge3Question2 {
   static int sumOfNums (int ...x) {
	   int sum = 0;
	   
	   for (int a : x) {
		   sum += a;
	   }
	   
	   return sum;
   }
   
   public static void main (String args[]) {
	   int sum = sumOfNums(1, 2, 3, 7, 8, -1 -9, 0, 10);
	   
	   System.out.println(sum);
   }
}
