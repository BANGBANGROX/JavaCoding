import java.util.Scanner;

public class Challenge3Question3 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter the string: ");
	   String str = sc.nextLine();
	   
	   int noOfWords = str.trim().replaceAll("\\s+", " ").split(" ").
			   length;
	   System.out.println("Total words: " + noOfWords);
	   
	   sc.close();	   
   }
}
