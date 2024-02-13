import java.util.*;

public class BlockSection {
    private String blockCode;
    private String description;
    private String adviser;
    private List<Student> studentList;
    @SuppressWarnings("unused")
    private Integer totalStudents;

    //setter method
    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    //getter methods
    public String getBlockCode() {
        return blockCode;
    }

    public String getDescription() {
        return description;
    }

    public String getAdviser() {
        return adviser;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Integer getTotalStudents() {
        if(studentList != null) {
            return studentList.size();
        } else {
            return 0;
        }
    }
}