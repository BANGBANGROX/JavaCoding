import java.util.*;

public class Challenge3Question2 {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter your site's URL: ");
	   String url = sc.next();
	   
	   String protocol = url.substring(0, url.indexOf(':'));
	   String type = url.substring(url.lastIndexOf('.') + 1);
	   
	   if (protocol.equals("http")) {
		   System.out.println("Hyper Text Transfer Protocol");
	   }
	   else if (protocol.equals("ftp")) {
		   System.out.println("File Transfer Protocol");
	   }
	   else if (protocol.equals("https")) {
		   System.out.println("Hyper Text Transfer Protocol Secured");
	   }
	   else {
		   System.out.println("Any other protocol " + protocol);
	   }
	   
	   if (type.equals("com")) {
		   System.out.println("Commercial");
	   }
	   else if (type.equals("org")) {
		   System.out.println("Organization");   
	   }
	   else if (type.equals("net")) {
		   System.out.println("Network");   
	   }
	   else {
		   System.out.println("Any other type");   
	   }
	   
	   sc.close();
   }
}
