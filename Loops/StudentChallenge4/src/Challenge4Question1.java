import java.util.*;

public class Challenge4Question1 {
  public static void main(String args[]) {
	  Scanner sc = new Scanner(System.in);
	  
	  int a = sc.nextInt();
	  int d = sc.nextInt();
	  int n = sc.nextInt();
	  
	  for (int i = 1;i <= n; ++i) {
		  int term = a + (i - 1) * d;
		  System.out.print(term + " ");
	  }
	  
	  sc.close();
  }
}
