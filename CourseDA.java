import java.io.*;
import java.util.*;

public class CourseDA {
    private List<Course> courseList;

    //getter method
    public List<Course> getCourseList() {
        return courseList;
    }

    //constructor
    public CourseDA(String studentNumber) throws FileNotFoundException {
        courseList = new ArrayList<>();

        Scanner stFile = new Scanner(new FileReader("studentInfo.csv"));

        while(stFile.hasNext()) {
            String stRaw = stFile.nextLine();
            String[] stArray = new String[4];
            stArray = stRaw.split(",");

            if(stArray[1].trim().equals(studentNumber)) {
                Scanner scFile = new Scanner(new FileReader("scheduleInfo.csv"));

                while(scFile.hasNext()) {
                    String scRaw = scFile.nextLine();
                    String[] scArray = new String[6];
                    scArray = scRaw.split(",");

                    if(stArray[1].trim().equals(scArray[0].trim())) {
                        Course c = new Course();

                        //set values
                        c.setCourseCode(scArray[1].trim());
                        c.setDescription(scArray[2].trim());
                        c.setUnit(Integer.valueOf(scArray[3].trim()));
                        c.setDay(scArray[4].trim());
                        c.setTime(scArray[5].trim());

                        courseList.add(c);
                    }
                }
                scFile.close();
            }
        }
        stFile.close();
    }
}