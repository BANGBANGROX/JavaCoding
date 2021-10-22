import java.util.*;

class Rectangle {
 	  public double length, breadth;
 	 
 	  public double calcArea() {
 		 double area = length * breadth;
 		 
 		 return area;
 	  }
 	 
 	  public double calcPerimeter() {
 		 double perimeter = 2 * (length + breadth);
 		 
 		 return perimeter;
 	  }
 	  
 	  public boolean isSquare() {
 		  boolean result = length == breadth;
 		  
 		  return result;
 	  }
  }
  
public class Challenge1Question1 { 
	
     public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	Rectangle rect = new Rectangle();
    	
    	System.out.println("Enter the length and the breadth of the rectangle: ");
    	
    	rect.length = sc.nextDouble();
    	rect.breadth = sc.nextDouble();
    	
        double area = rect.calcArea();
        double perimeter = rect.calcPerimeter();
        boolean squareCheck = rect.isSquare();
        
        System.out.println("Area = " + area + " sq units\nPerimeter = " + perimeter + (squareCheck ? " units\nIt "
        		+ "is a sqaure" : " units\nIt is not a square"));
        
        sc.close();
     }
}
