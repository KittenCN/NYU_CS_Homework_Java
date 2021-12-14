package FinalExamFALL2021;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class Course{
    String strCourseName;
    String strInstructor;
    int intSectionNumber;
    int intStudents;
    String strLocation;
    Course(){
        strCourseName = "";
        strInstructor = "";
        intSectionNumber = -1;
        intStudents = -1;
        strLocation = "";
    }
    Course(String strCourseName, String strInstructor, int intSectionNumber, int intStudents, String strLocation){
        this.strCourseName = strCourseName;
        this.strInstructor = strInstructor;
        this.intSectionNumber = intSectionNumber;
        this.intStudents = intStudents;
        this.strLocation = strLocation;
    }
    public String getstrCourseNmae(){
        return strCourseName;
    }
    public String getstrInstructor(){
        return strInstructor;
    }
    public int getintSectionNumber(){
        return intSectionNumber;
    }
    public int getintStudents(){
        return intStudents;
    }
    public String getstrLocation(){
        return strLocation;
    }
    public void setstrCourseNmae(String strCourseName){
        this.strCourseName = strCourseName;
    }
    public void setstrInstructor(String strInstructor){
        this.strInstructor = strInstructor;
    }
    public void setintSectionNumber(int intSectionNumber){
        this.intSectionNumber = intSectionNumber;
    }
    public void setintStudents(int intStudents){
        this.intStudents = intStudents;
    }
    public void setstrLocation(String strLocation){
        this.strLocation = strLocation;
    }
}
class Courses extends Course{
    public static String strPath = "FinalExamFALL2021/";
    final static int intMaxIndex = 1005;
    public static int intIndex = 0;
    public static Course[] courses = new Course[intMaxIndex];
    public static Course[] ceReadingCSV(String strFilePath) throws FileNotFoundException{
        Course[] Courses = new Course[intMaxIndex];
        Path path = Paths.get(strFilePath);
        if(!Files.exists(path)){
            throw new IllegalArgumentException("File does not exist!");
        }
        String strLine = " ";
        Scanner sc = new Scanner(new File(strFilePath));
        try{
            while(strLine != null){
                strLine = sc.nextLine();
                String[] strLineArray = strLine.split(",");
                if(strLineArray[0].equals("Course_Name")){
                    continue;
                }
                Course c = new Course(strLineArray[0], strLineArray[1], Integer.parseInt(strLineArray[2]), Integer.parseInt(strLineArray[3]), strLineArray[4]);
                Courses[intIndex++] = c;
            }
        }
        catch(NoSuchElementException e){
            System.out.println("Read complete!");
        }
        return Courses;
    }
    public static int find(String strCourseName, int intSectionNumber){
        int intAns = -1;
        for(int i = 0; i < intIndex; ++i){
            if(courses[i].strCourseName.equals(strCourseName) && courses[i].intSectionNumber == intSectionNumber){
                intAns = i;
            }
        }
        return intAns;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sa = new Scanner(System.in);
        String strMenu = "1. Load data from the CSV file\r\n2. Add a new course\r\n3. Edit a course\r\n4. Display all courses\r\n5. Search for a course\r\n6. Delete a course\r\n7. Sort courses by number of students registered and display them\r\n8. Display all courses with number of students above 30 students\r\n9. Write data to a new text file\r\n10. Exit";
        int intChoice = -1;
        
        while(intChoice != 10){
            System.out.println(strMenu);
            intChoice = sa.nextInt();
            switch(intChoice){
                case 1:
                    // Load data from the CSV file
                    String strFileName = "courses.csv";
                    courses = ceReadingCSV(strPath + strFileName);
                    break;
                case 2:
                    // Add a new course
                    System.out.print("Enter the course name: ");
                    String course_name = sa.nextLine();
                    System.out.println("Enter the instructor: ");
                    String course_instructor = sa.nextLine();
                    System.out.println("Enter the course section number: ");
                    int course_section_number = sa.nextInt();
                    System.out.println("Enter the current students: ");
                    int current_students = sa.nextInt();
                    System.out.println("Enter course location: ");
                    String course_location = sa.nextLine();
                    Course newCourse = new Course(course_name, course_instructor, course_section_number, current_students, course_location);
                    courses[intIndex++] = newCourse;
                    break;
                case 3:
                    // Edit a course
                    System.out.print("Enter the course name: ");
                    course_name = sa.nextLine();
                    System.out.println("Enter the course section number: ");
                    course_section_number = sa.nextInt();
                    int index = find(course_name, course_section_number);
                    if(index < 0){
                        System.out.println("Course not found!");
                    }
                    else{
                        System.out.println("Enter the new course name: ");
                        course_name = sa.nextLine();
                        System.out.println("Enter the new instructor: ");
                        course_instructor = sa.nextLine();
                        System.out.println("Enter the new course section number: ");
                        course_section_number = sa.nextInt();
                        System.out.println("Enter the new current students: ");
                        current_students = sa.nextInt();
                        System.out.println("Enter the new course location: ");
                        course_location = sa.nextLine();
                        
                    }
                    break;
                case 4:
                    System.out.println("Display all courses");
                    break;
                case 5:
                    System.out.println("Search for a course");
                    break;
                case 6:
                    System.out.println("Delete a course");
                    break;
                case 7:
                    System.out.println("Sort courses by number of students registered and display them");
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid Input! Try again!");
                    break;
            }
        }
        sa.close();
    }
}