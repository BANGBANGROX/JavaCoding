import java.util.*;

public class Challenge4Question2 {
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
 	   
	    System.out.println("Enter the rows and coloumns of matrix A: ");
	    int row1 = sc.nextInt();
	    int col1 = sc.nextInt();
	    
	    int a[][] = new int[row1][col1];
	    
	    System.out.println("Enter matrix A: ");
	    
	    for (int i = 0; i < row1; ++i) {
	    	for (int j = 0; j < col1; ++j) {
	    		a[i][j] = sc.nextInt();
	    	}
	    }
	    
	    System.out.println("Enter the rows and coloumns of matrix B: ");
	    int row2 = sc.nextInt();
	    int col2 = sc.nextInt();
	    
	    int b[][] = new int[row2][col2];
	    
	    System.out.println("Enter matrix B: ");
	    
	    for (int i = 0; i < row2; ++i) {
	    	for (int j = 0; j < col2; ++j) {
	    		b[i][j] = sc.nextInt();
	    	}
	    }
	    
	    if (col1 == row2) {
	       int product[][] = new int[row1][col2];
	       
	       System.out.println("Product of A and B is: ");
	       
	       for (int i = 0; i < row1; ++i) {
	    	  for (int j = 0; j < col2; ++j) {
	    	     for (int k = 0; k < col1; ++k) {
	    	    	 product[i][j] += a[i][k] * b[k][j];
	    	     }
	    	     System.out.print(product[i][j] + " ");
	    	  }
	    	  System.out.println("");
	       }
	       
	    }
	    else {
	    	System.out.println("Product not possible");
	    }
	    
	    sc.close(); 
   }
}
