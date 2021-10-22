import java.util.*;

public class Challenge2Question1 {
   static double PI = 3.14159;	
   
   static double calcArea (double length, double breadth) {
	   double area = length * breadth;
	   
	   return area;
   }
   
   static double calcArea (double radius) {
	  double area = PI * radius * radius;
	  
	  return area;
   }
	
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("1. Rectangle\n2. Circle\nWhat you want to choose");
	   
	   int choice = sc.nextInt();
	   
	   if (choice == 1) {
		  System.out.println("Enter length and breadth of the rectangle: ");
		  double length = sc.nextDouble();
		  double breadth = sc.nextDouble();
		  
		  double area = calcArea(length, breadth);
		  
		  System.out.println("Area of the rectangle is " + area);
	   }
	   else {
		   System.out.println("Enter the radius of the circle");
		   double radius = sc.nextDouble();
		   
		   double area = calcArea(radius);
		   
		   System.out.println("Area of the circle is " + area);
	   }
	   
	   sc.close();   
   }
}
