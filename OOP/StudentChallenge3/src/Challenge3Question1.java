import java.util.*;

class Student {
	public String rollNo, name, course;
	public double m1, m2, m3;
	
	public double calcTotal() {
		double total = m1 + m2 + m3;
		
		return total;
	}
	
	public double calcAverage() {
		double avg = calcTotal() / 3;
		
		return avg;
	}
	
	public char calcGrade() {
	    double avg = calcAverage();
	    char grade = 'F';
	    
	    if (avg >= 70) grade = 'A';
	    else if (avg >= 60 && avg < 70) grade = 'B';
	    else if (avg >= 50 && avg < 60) grade = 'C';
	    else if (avg >= 40 && avg < 50) grade = 'D';
	    
	    return grade;
	}
}

public class Challenge3Question1 {
    public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
        Student stud = new Student();
        
        System.out.println("Enter student name, roll no, course, marks in 3 subjects: ");
        
        stud.name = sc.nextLine();
        stud.rollNo = sc.next();
        stud.course = sc.next();
        stud.m1 = sc.nextDouble();
        stud.m2 = sc.nextDouble();
        stud.m3 = sc.nextDouble();
        
        double total = stud.calcTotal();
        double avg = stud.calcAverage();
        char grade = stud.calcGrade();
        
        System.out.format("Student result\nName = %s\nRoll No. = %s\nCourse = %s\nTotal = %.2f\n"
        		+ "Average = %.2f\nGrade = %c\n", stud.name, stud.rollNo, stud.course, total, avg, grade);
        
        sc.close();
        
    }
}
