import java.util.*;

public class Challenge4Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int a = sc.nextInt();
	   int r = sc.nextInt();
	   int n = sc.nextInt();
	   
	   for (int i = 1; i <= n; ++i) {
		   int term = a * (int)Math.pow(r, i - 1);
		   System.out.print(term + " ");
	   }
	   
	   sc.close();
   }
}
