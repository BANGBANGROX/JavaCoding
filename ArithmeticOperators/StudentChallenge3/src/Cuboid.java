import java.util.*;

public class Cuboid {
	
   public static void main(String args[]) {
	   
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("Enter the values for length, breadth and height: ");
	  
	  double length = sc.nextDouble();
	  double breadth = sc.nextDouble();
	  double height = sc.nextDouble();
	  
	  double lsa = 2 * (length + breadth) * height;
	  double tsa = lsa + 2 * length * breadth;
	  double volume = length * breadth * height;
	  
	  System.out.println("Lateral Surface Area = " + lsa + "\nTotal Surface"
	  		+ "Area = " + tsa + "\nVolume = " + volume);
	  
      sc.close();	  
   }
}
