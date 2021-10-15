public class Challenge5Question3 {
  public static void main(String args[]) {
	  /* 2 3 4 5 6
	   * 3 4 5 6 7
	   * 4 5 6 7 8
	   * 5 6 7 8 9
	   * 6 7 8 9 10
	   */
	  for (int i = 1; i <= 5; ++i) { 
		 for (int j = 1; j <= 5; ++j) {
			System.out.format("%02d ",(i + j));
		  }
		 System.out.println("");
	  }
  }
}
