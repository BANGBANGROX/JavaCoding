import java.util.*;

public class Challenge4Question1 {
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
	    
	    if(row1 == row2 && col1 == col2) {
	        int sum[][] = new int[row1][col1];
	        
	        System.out.println("Sum of A and B is: ");
	        
	        for (int i = 0; i < row1; ++i) {
	        	for (int j = 0; j < col1; ++j) {
	               sum[i][j] = a[i][j] + b[i][j];	
	               System.out.print(sum[i][j] + " ");
	        	}
	        	System.out.println("");
	        }
	    }
	    else {
	    	System.out.println("Addition not possible");
	    }
	    
	    sc.close();
   }
}
