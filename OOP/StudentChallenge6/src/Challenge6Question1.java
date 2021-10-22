class Subject {
    private String subId, name;
    private int maxMarks, marksObtained;

    public Subject (String subId, String name, int maxMarks, int marksObtained) {
        this.subId = subId;
        this.name = name;
        setMaxMarks(maxMarks);
        setMarksObtained(marksObtained);
    }

    public String getSubId() {
        return subId;
    }

    public String getName() {
        return name;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks (int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained (int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public String toString() {
        return "ID = " + subId + "\nName = " + name + "\nMax Marks = " + maxMarks +
                "\nMarks Obtained = " + marksObtained;
    }
}

class Student {
    private String rollNo, name, department;
    private Subject[] subjects;

    public Student (String rollNo, String name, String department, Subject[] subjects) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        setSubjects(subjects);
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setSubjects (Subject[] subjects) {
        this.subjects = subjects;
    }

    public String toString() {
        System.out.println("Name = " + name + "\nRoll No = " + rollNo + "\nDepartment = " + department +
                "\nSubjects: ");

        for (Subject s : subjects) {
            System.out.println(s);
        }

        return "";
    }

}

public class Challenge6Question1 {

   public static void main (String args[]) {

       Subject []sub = new Subject[3];

       sub[0] = new Subject("CS1501", "Computer Graphics", 100, 78);
       sub[1] = new Subject("CS1502", "Computer Networks", 100, 72);
       sub[2] = new Subject("CS1503", "Software Engineering", 100, 80);

       Student stud = new Student("2019UGCS082", "Lakshya Bang", "CSE", sub);

       System.out.println(stud);
   }
}
