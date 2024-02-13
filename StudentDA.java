import java.io.*;
import java.util.*;

public class StudentDA {
    private List<Student> studentList;

    //getter method
    public List<Student> getStudentList() {
        return studentList;
    }

    //constructor
    public StudentDA(String blockCode) throws FileNotFoundException {
        studentList = new ArrayList<>();

        Scanner bsFile = new Scanner(new FileReader("blockSection.csv"));

        while(bsFile.hasNext()) {
            String bsRaw = bsFile.nextLine();
            String[] bsArray = new String[3];
            bsArray = bsRaw.split(",");

            if(bsArray[0].trim().equals(blockCode)) {
                Scanner stFile = new Scanner(new FileReader("studentInfo.csv"));

                while(stFile.hasNext()) {
                    String stRaw = stFile.nextLine();
                    String[] stArray = new String[4];
                    stArray = stRaw.split(",");

                    if(bsArray[0].trim().equals(stArray[0].trim())) {
                        Student st = new Student();

                        //set values
                        st.setStudentNumber(stArray[1].trim());
                        st.setName(stArray[2].trim());
                        st.setProgram(stArray[3].trim());

                        CourseDA courseDA = new CourseDA(st.getStudentNumber());
                        st.setCourseList(courseDA.getCourseList());

                        studentList.add(st);
                    }
                }
                stFile.close();
            }
        }
        bsFile.close();
    }
}