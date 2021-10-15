import java.util.*;

public class Challenge1Question3 {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter your marks out of 100 in 3 subjects: ");
    	int m1 = sc.nextInt();
    	int m2 = sc.nextInt();
    	int m3 = sc.nextInt();
    	
    	int total = m1 + m2 + m3;
    	float avg = (float)total / 3;
    	char grade = 'E';
    	
    	if(avg >= 70) grade = 'A';
    	else if(avg >= 60) grade = 'B';
    	else if(avg >= 50) grade = 'C';
    	else if(avg >= 40) grade = 'D';
    	else grade = 'F';
    	
    	System.out.println("Your Result: \n" + "Total: " + total + "\n" + "Average: " + avg + "\n"
    			  + "Grade: " + grade);
    	
    	sc.close();
    }
}
