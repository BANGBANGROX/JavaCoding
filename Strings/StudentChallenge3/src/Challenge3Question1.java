import java.util.*;

public class Challenge3Question1 {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter a string: ");
    	String str = sc.next();
    	
    	String filteredStr = str.replaceAll("\\W","");
    	System.out.println("Filtered string is: " + filteredStr);
    	
    	sc.close();
    }
}
