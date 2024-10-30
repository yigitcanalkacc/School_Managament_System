package User;

public class Student {

    private int stdNo;
    private String name;
    private int grade; 
    private String course;

    public Student(String name, int grade, String course, int stdNo) {
        this.name = name;
        this.grade = grade;
        this.course = course;
        this.stdNo = stdNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() { 
        return grade;
    }

    public void setGrade(int grade) { 
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getStdNo() {
        return stdNo;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }
    
    
}
