import java.util.*;

public class Challenge4Question3 {
	public static void main(String args[]) {
	       Scanner sc = new Scanner(System.in);
	       
	       System.out.println("Enter your site's URL: ");
	       String url = sc.next();
	       
	       String type = url.substring(url.lastIndexOf('.') + 1);
	       String res = "Any other type";
	       
	       switch(type) {
	       case "com" : res = "Commercial";
	       				break;
	       case "org" : res = "Organization";
	       				break;
	       case "net" : res = "Network";
	       				break;
	       }
	       
	       System.out.println(res);
	       
	       sc.close();
	}
}
