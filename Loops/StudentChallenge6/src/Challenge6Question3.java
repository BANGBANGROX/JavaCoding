public class Challenge6Question3 {
   public static void main(String args[]) {
	   /* 1 2 3 4 5
	    * 1 2 3 4
	    * 1 2 3
	    * 1 2
	    * 1
	    */
	   for (int i = 5; i > 0; --i) {
		   for (int j = 1; j <= i; ++j) {
			   System.out.print(j + " ");
		   }
		   System.out.print("\n");
	   }
   }
}
