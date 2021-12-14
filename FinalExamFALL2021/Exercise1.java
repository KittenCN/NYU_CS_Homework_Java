package FinalExamFALL2021;
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
    public int getstrLocation(){
        return strLocation;
    }
    public void setstrCourseNmae(String strCourseName){
        this.strCourseName = strCourseName;
    }
    public void setintSectionNumber(int intSectionNumber){
        this.intSectionNumber = intSectionNumber;
    }
    
}