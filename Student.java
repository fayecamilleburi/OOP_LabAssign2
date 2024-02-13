import java.util.*;

public class Student {
    private String studentNumber;
    private String name;
    private String program;
    private List<Course> courseList;
    @SuppressWarnings("unused")
    private Integer totalUnitsEnrolled;

    //setter method
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setTotalUnitsEnrolled(Integer totalUnitsEnrolled) {
        this.totalUnitsEnrolled = totalUnitsEnrolled;
    }

    //getter method
    public String getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public Integer getTotalUnitsEnrolled() {
        int totalUnitsEnrolled = 0;
        if(courseList != null) {
            for(Course course: courseList) {
                totalUnitsEnrolled += course.getUnit();
            }
        }
        return totalUnitsEnrolled;
    }
}