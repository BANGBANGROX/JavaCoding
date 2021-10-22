import java.util.*;

public class Challenge2Question3 {
   static boolean validate (String name) {
	   boolean result = name.matches("[A-Z][a-z]+[\s][A-Z][a-z]+");
	   
	   return result;
   }
   
   static boolean validate (int age) {
	   boolean result = age > 2 && age < 16;
	   
	   return result;
   }
   
   public static void main (String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter your full name and age: ");
	   
	   String name = sc.nextLine();
	   int age = sc.nextInt();
	   
	   boolean nameRes = validate(name);
	   boolean ageRes = validate(age);
	   
	   if (!nameRes) {
		  System.out.println("Incorrect name written!");   
	   }
	   else {
		   System.out.println("Correct name written!");
	   }
	   if (!ageRes) {
		   System.out.println("Incorrect age written!");   
	   }
	   else {
		   System.out.println("Correct age written!");
	   }
	   
	   sc.close();
   }
   
   
}
