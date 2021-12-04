package JavaExceptionsPractice;
import java.util.*;
class Student{
    String name;
    int age;
    String motivation;
    Student(){
        name = "";
        age = -1;
        motivation = "";
    }
    Student(String name, int age, String motivation){
        this.name = name;
        this.age = age;
        this.motivation = motivation;
    }
    public int getAge() {
        return age;
    }
    public String getMotivation() {
        return motivation;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age)  {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
    }
    public void setMotivation(String motivation) {
        if (motivation == null) {
            throw new IllegalArgumentException("Motivation cannot be null");
        }
        this.motivation = motivation;
    }
    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
}
class jep{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the student");
        String name = sc.nextLine();
        System.out.println("Enter the age of the student");
        int age = sc.nextInt();
        System.out.println("Enter the motivation of the student");
        String motivation = sc.nextLine();
        Student s = new Student(name, age, motivation);
        try {
            s.setAge(age);
            s.setMotivation(motivation);
            s.setName(name);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
        System.out.println("Motivation: " + s.getMotivation());
    }
}