import java.util.*;

public class Challenge4Question3 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   int first = 1, second = 1;
	   int n = sc.nextInt();
	   
	   System.out.print(first + " " + second);
	   
	   for (int i = 3; i <= n; ++i) {
		   int third = first + second;
		   System.out.print(" " + third);
		   first = second;
		   second = third;
	   }
	   
	   sc.close();
   }
}
