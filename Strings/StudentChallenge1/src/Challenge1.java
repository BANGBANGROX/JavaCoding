import java.util.*;

public class Challenge1 {
     public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter your email address: ");
    	String email = sc.next();
    	
    	String userName = email.substring(0, email.indexOf('@'));
    	String domainName = email.substring(email.indexOf('@') + 1);
    	
    	System.out.println(userName + " " + domainName);
    	
    	if(domainName.equals("gmail.com")) {
    		System.out.println("You have an account on gmail!");
    	}
    	else {
    		System.out.println("You don't have an account on gmail, make"
    				+ " one now!"); 	
    	}
    	
       	sc.close();
     }
    	
}
