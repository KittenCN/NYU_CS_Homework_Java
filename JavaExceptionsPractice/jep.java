package JavaExceptionsPractice;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
            throw new IllegalArgumentException("!!Age cannot be negative");
        }

        this.age = age;
    }
    public void setMotivation(String motivation) {
        if (motivation == null) {
            throw new IllegalArgumentException("!!Motivation cannot be null");
        }
        this.motivation = motivation;
    }
    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("!!Name cannot be empty");
        }
        this.name = name;
    }
    public static String getSomeMotivation() throws IOException {
		// create a client
		String motivation = "";
        URL oracle = new URL("https://www.affirmations.dev/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            motivation = (inputLine.substring(15,inputLine.length()-1));
        in.close();
		return motivation;
	}
}
class FileIO{
    String FileAddress;
    FileIO(String FileAddress){
        this.FileAddress = FileAddress;
    }
    public String reading(int num){
        String[] strArray = new String[100];
        File file = new File(this.FileAddress);
        Path path = Paths.get(file.getAbsolutePath() + "/File.txt");
        if(!Files.exists(path)){
            throw new IllegalArgumentException("!!File does not exist");
        }
        if(num > 100 || num < 0){
            throw new IllegalArgumentException("!!Number of lines to read is out of range");
        }
        try{
            Scanner fi = new Scanner(path);
            for(int i = 0; i <= num; i++){
                strArray[i] = fi.nextLine();
            }
            fi.close();
            return strArray[num];
        }
        catch(FileNotFoundException e){
            return "!!File not found";
        }     
        catch(NoSuchElementException e){
            return "!!No such element";
        } 
        catch (IOException e) {
            return "IOException";
        }
    }
}
class jep{
    public static void main(String[] args) throws IOException {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Enter the age of the student");
                int age = sc.nextInt();
                s.setAge(age);
            }
            catch (InputMismatchException  e) {
                System.out.println("Input Mismatch Exception: " + e.getMessage());
                break;
            }
            finally{
                System.out.println("!!Finally block is executed");
            }
        }
        while(true){
            try{
                System.out.println("Enter the name of the student");
                String name = sc.nextLine();
                s.setName(name);
            }
            catch (IllegalArgumentException  e) {
                System.out.println("Input Mismatch Exception: " + e.getMessage());
                break;
            }
            finally{
                System.out.println("!!Finally block is executed");
            }
        }
        try{
            String FileAddress = "JavaExceptionsPractice/";
            FileIO f = new FileIO(FileAddress);
            System.out.println("Enter the number of lines to read: ");
            int num = sc.nextInt();
            System.out.println(f.reading(num));
        }
        catch(IllegalArgumentException e){
            System.out.println("!!Illegal Argument Exception: " + e.getMessage());
        }
        finally{
            System.out.println("!!Finally block is executed");
        }
        System.out.println("Enter 1st number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter 2nd number: ");
        int num2 = sc.nextInt();
        try{
            int result = num1 / num2;
            System.out.println("Result: " + result);
        }
        catch(ArithmeticException e){
            System.out.println("!!Arithmetic Exception: " + e.getMessage());
        }
        finally{
            System.out.println("!!Finally block is executed");
        }
        sc.close();
        System.out.println(Student.getSomeMotivation());
    }
}