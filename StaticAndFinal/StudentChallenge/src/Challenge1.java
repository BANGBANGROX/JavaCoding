import java.util.Date;

class Student {
    private String rollNo, name;
    private static int count = 0;

    public Student(String name) {
       rollNo = generateRollNo();
       this.name = name;
    }

    private String generateRollNo() {
        ++count;
        Date d = new Date();
        String rollNo = "UNIV" + (d.getYear() + 1900) + count;

        return rollNo;
    }

    public String toString() {
        return "Name: " + name + "\nRoll No. = " + rollNo + "\n";
    }
}

public class Challenge1 {
    public static void main(String[] args) {
        Student s1 = new Student("Bilal Sheikh");
        Student s2 = new Student("Asad Rauf");
        Student s3 = new Student("Osama Bin Laden");
        Student s4 = new Student("Abu Bakhar Al Baghdadi");

        System.out.printf("%s\n%s\n%s\n%s",s1, s2, s3, s4);
    }

}
