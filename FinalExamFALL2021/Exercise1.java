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
    public String getstrCourseName(){
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
    public void setstrCourseName(String strCourseName){
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
class cmp implements Comparator<Course>{
    public int compare(Course courseA, Course courseB){
        if(courseA.intStudents < courseB.intStudents){
            return -1;
        }
        else if(courseA.intStudents == courseB.intStudents){
            return 0;
        }
        else{
            return 1;
        }
    }
}
class Courses extends Course{
    public static String strPath = "FinalExamFALL2021/";
    public static String strUseless = "";
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
        sc.close();
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
    public static void show(boolean sorted, int intMaxLine, int intMaxNum){
        Course[] tempCourses = courses;
        if(sorted){
            Arrays.sort(tempCourses, 0, intIndex, new cmp());
        }
        for(int i = 0; i < intMaxLine; ++i){
            if((intMaxNum > 0 && tempCourses[i].intStudents > intMaxNum) || intMaxNum <= 0){
                System.out.println(tempCourses[i].strCourseName + " | " + tempCourses[i].strInstructor + " | " + tempCourses[i].intSectionNumber + " | " + tempCourses[i].intStudents + " | " + tempCourses[i].strLocation);
            }
        }
    }
    public static void show(int intLine){
        Course[] tempCourses = courses;
        int i = intLine;
        System.out.println(tempCourses[i].strCourseName + " | " + tempCourses[i].strInstructor + " | " + tempCourses[i].intSectionNumber + " | " + tempCourses[i].intStudents + " | " + tempCourses[i].strLocation);
    }
    public static void del(int intLine){
        Course[] tempCourses = courses;
        courses = new Course[intMaxIndex];
        for(int i = 0; i < intLine; ++i){
            courses[i] = tempCourses[i]; 
        }
        for(int i = intLine + 1; i < intIndex; ++i){
            courses[i - 1] = tempCourses[i];
        }
        intIndex--;
    }
    public static void saveToFile(String strFilePath, int intMaxNum){
        Course[] Courses = new Course[intMaxIndex];
        Course[] tempCourses = courses;
        Arrays.sort(tempCourses, 0, intIndex, new cmp());
        int intAnsIndex = 0;
        for(int i = 0; i < intIndex; ++i){
            if((intMaxNum > 0 && tempCourses[i].intStudents > intMaxNum) || intMaxNum <= 0){
                Course temp = new Course(tempCourses[i].strCourseName, tempCourses[i].strInstructor, tempCourses[i].intSectionNumber, tempCourses[i].intStudents, tempCourses[i].strLocation);
                Courses[intAnsIndex++] = temp;
            }
        }
        try{
            Path path = Paths.get(strFilePath);
            BufferedWriter out = new BufferedWriter(new FileWriter(path.toString()));
            for(int i = 0; i < intAnsIndex; i++){
                if(Courses[i] != null){
                    String strWr = Courses[i].strCourseName + ',' + Courses[i].strInstructor + ',' + Courses[i].intSectionNumber + ',' + Courses[i].intStudents + ',' + Courses[i].strLocation + "\r\n";
                    out.write(strWr);
                }
            }
            out.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sa = new Scanner(System.in);
        String strMenu = "1. Load data from the CSV file\r\n2. Add a new course\r\n3. Edit a course\r\n4. Display all courses\r\n5. Search for a course\r\n6. Delete a course\r\n7. Sort courses by number of students registered and display them\r\n8. Display all courses with number of students above 30 students\r\n9. Write data to a new text file\r\n10. Exit";
        int intChoice = -1;
        
        while(intChoice != 10){
            System.out.println(strMenu);
            intChoice = sa.nextInt();
            strUseless = sa.nextLine(); // fix nextLine bug
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
                    System.out.print("Enter the instructor: ");
                    String course_instructor = sa.nextLine();
                    System.out.print("Enter the course section number: ");
                    int course_section_number = sa.nextInt();
                    strUseless = sa.nextLine();  
                    System.out.print("Enter the course students: ");
                    int course_students = sa.nextInt();
                    strUseless = sa.nextLine();
                    System.out.print("Enter course location: ");
                    String course_location = sa.nextLine();
                    Course newCourse = new Course(course_name, course_instructor, course_section_number, course_students, course_location);
                    courses[intIndex++] = newCourse;
                    break;
                case 3:
                    // Edit a course
                    System.out.print("Enter the course name: ");
                    course_name = sa.nextLine();
                    System.out.print("Enter the course section number: ");
                    course_section_number = sa.nextInt();
                    strUseless = sa.nextLine();
                    int index = find(course_name, course_section_number);
                    if(index < 0){
                        System.out.println("Course not found!");
                    }
                    else{
                        System.out.print("Enter the new course name: ");
                        course_name = sa.nextLine();
                        System.out.print("Enter the new instructor: ");
                        course_instructor = sa.nextLine();
                        System.out.print("Enter the new course section number: ");
                        course_section_number = sa.nextInt();
                        strUseless = sa.nextLine();
                        System.out.print("Enter the new current students: ");
                        course_students = sa.nextInt();
                        strUseless = sa.nextLine();
                        System.out.print("Enter the new course location: ");
                        course_location = sa.nextLine();
                        Course current_course = courses[index];
                        current_course.setstrCourseName(course_name);
                        current_course.setstrInstructor(course_instructor);
                        current_course.setintSectionNumber(course_section_number);
                        current_course.setintStudents(course_students);
                        current_course.setstrLocation(course_location);
                    }
                    break;
                case 4:
                    // Display all courses
                    show(false, intIndex, 0);
                    break;
                case 5:
                    // Search for a course
                    System.out.print("Enter the course name: ");
                    course_name = sa.nextLine();
                    System.out.print("Enter the course section number: ");
                    course_section_number = sa.nextInt();
                    strUseless = sa.nextLine();
                    index = find(course_name, course_section_number);
                    if(index < 0){
                        System.out.println("Course not found!");
                    }
                    else{
                        show(index);
                    }
                    break;
                case 6:
                    //  Delete a course
                    System.out.print("Enter the course name: ");
                    course_name = sa.nextLine();
                    System.out.print("Enter the course section number: ");
                    course_section_number = sa.nextInt();
                    strUseless = sa.nextLine();
                    index = find(course_name, course_section_number);
                    if(index < 0){
                        System.out.println("Course not found!");
                    }
                    else{
                        del(index);
                    }
                    break;
                case 7:
                    // Sort courses by number of students registered and display them
                    show(true, intIndex, 0);
                    break;
                case 8:
                    // Display all courses with number of students above 30 students
                    show(true, intIndex, 30);
                    break;
                case 9:
                    // Write data (of the results of menu option# 8) to a new text file
                    strFileName = "newdata.csv";
                    saveToFile(strPath + strFileName, 30);
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