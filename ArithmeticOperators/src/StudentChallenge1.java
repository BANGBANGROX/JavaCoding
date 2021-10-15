import java.lang.*;
import java.util.*;

public class StudentChallenge1 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
        // Area using base and height
//		System.out.println("Enter base and height of the triangle: ");
//
//		float base = sc.nextFloat();
//		float height = sc.nextFloat();
//
//		float area = 0.5f * base * height;
//
//		System.out.println("Area of triangle is: " + area + " sq units");
		
		// Area using sides a,b,c
		System.out.println("Enter the sides of the triangle: ");
		
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		
		float s = (a + b + c) / 2;
		double area = Math.sqrt((double)s * (s - a) * (s - b) * (s - c));
		
		System.out.println("Area of the triangle is: " + area + " sq units");

		sc.close();
	}

}
