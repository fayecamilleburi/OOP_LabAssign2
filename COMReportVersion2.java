import java.io.*;
import java.util.*;

public class COMReportVersion2 {

    public static void main(String[] args) throws FileNotFoundException {
        BlockSectionDA blockSectionDA = new BlockSectionDA();

        List<BlockSection> bsList = blockSectionDA.getBlockSectionList();

        StringBuilder result = new StringBuilder();

        for(BlockSection bs: bsList) {
            result.append("\nBlock section code: ").append(bs.getBlockCode()).append("\n")
                  .append("Description: ").append(bs.getDescription()).append("\n")
                  .append("Adviser: ").append(bs.getAdviser()).append("\n\n")
                  .append("Total Students: ").append(bs.getTotalStudents()).append("\n");

            List<Student> stList = bs.getStudentList();
            for(Student st: stList) {
                result.append("\nStudent number: ").append(st.getStudentNumber()).append("\n")
                      .append("Name: ").append(st.getName()).append("\n")
                      .append("Program: ").append(st.getProgram()).append("\n")
                      .append("Total Units Enrolled: ").append(st.getTotalUnitsEnrolled()).append("\n\n");
                    
                    List<Course> cList = st.getCourseList();
                    if(cList != null && !cList.isEmpty()) {
                        result.append(String.format("%-15s%-30s%-8s%-7s%-15s%n",
                                "Course code",
                                        "Description",
                                        "Units",
                                        "Day",
                                        "Time"));
                        for(Course c: cList) {
                            result.append(String.format("%-15s%-30s%-8s%-7s%-15s%n",
                                c.getCourseCode(),
                                c.getDescription(),
                                c.getUnit(),
                                c.getDay(),
                                c.getTime()));
                        }
                    }
                }
            }
            System.out.println(result.toString());
        }
    }
