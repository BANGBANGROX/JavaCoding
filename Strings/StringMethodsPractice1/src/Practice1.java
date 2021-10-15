import java.lang.*;

public class Practice1 {
    public static void main(String args[]) {
    	String s = " Lakshya Bang ";
    	
    	int len = s.length();
    	System.out.println(len);
    	
    	String lowS = s.toLowerCase();
    	System.out.println(lowS + " " + s);
    	
    	String upS = s.toUpperCase();
    	System.out.println(upS + " " + s);
    	
    	String trimS = s.trim();
    	System.out.println(trimS + " " + s);
    	
    	String subS1 = s.substring(2);
    	System.out.println(subS1);
    	
    	String subS2 = s.substring(3, 10);
    	System.out.println(subS2);
    	
    	String replaceS = s.replace('a', 'b');
    	System.out.println(replaceS);    	    	
    	   	
    }
}
