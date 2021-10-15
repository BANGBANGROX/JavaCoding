import java.lang.*;

public class Practice2 {
   public static void main(String args[]) {
	   String mc = "Mr. Aryan Khan";
	   
	   boolean starts1 = mc.startsWith("Mr.");
	   System.out.println(starts1);
	   
	   boolean starts2 = mc.startsWith("Aryan", 4);
	   System.out.println(starts2);
	   
	   boolean ends = mc.endsWith("Khan");
	   System.out.println(ends);
	   
	   char ch = mc.charAt(2);
	   System.out.println(ch);
	   
	   int index1 = mc.indexOf("Khan");
	   System.out.println(index1);
	   
	   int index2 = mc.lastIndexOf("an");
	   System.out.println(index2);
   }
}
