import java.util.*;
import java.lang.*;
public class Keyboard {
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		
		String name = sc.nextLine();
		
		System.out.println("Welcome " + name);
		
		System.out.println("Enter two numbers: ");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int sum = a + b;
		
		System.out.print("Sum of " + a + " and " + b + " is " + sum);
		
		sc.close();
	}
}
