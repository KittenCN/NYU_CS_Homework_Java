package QiuanYu_Homework_7.HW7Exercise1;
import java.util.Scanner;
class PhoneBookEntry{
    final static int intIndex = 3;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String zipcode;

    public PhoneBookEntry(){
        id = -1;
        firstName = "";
        lastName = "";
        email = "";
        phoneNumber = "";
        zipcode = "";
    }
    public PhoneBookEntry(int id, String firstName, String lastName, String email, String zipcode, String phoneNumber){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.zipcode = zipcode;
    }
    public PhoneBookEntry(String firstName, String phoneNumber){
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.id = -1;
        this.lastName = "";
        this.email = "";
        this.zipcode = "";
    }
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getZipcode(){
        return zipcode;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }
    public void printBookEntry(){
        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Zipcode: " + zipcode);
    }
}
class PhoneBook extends PhoneBookEntry{
    public static Scanner sa = new Scanner(System.in);
    final static int intIndex = 3;
    PhoneBookEntry[] phoneBook = new PhoneBookEntry[intIndex];
    public PhoneBook(){
            
    }
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();  // create a phone book
        // add some entries
        PhoneBookEntry firstObj = new PhoneBookEntry(5, "John", "Smith", "jsmith@gmail.edu", "20037", "2023334444");
        PhoneBookEntry secondObj = new PhoneBookEntry("James", "202344344");
        PhoneBookEntry ThirdObj = new PhoneBookEntry();
        ThirdObj.setFirstName("Satah");
        // add the entries to the phone book
        pb.phoneBook[0] = firstObj;
        pb.phoneBook[1] = secondObj;
        pb.phoneBook[2] = ThirdObj;
        String oriZipcode = ""; // the zipcode to search for
        for(int i = 0; i < intIndex; i++){
            if(pb.phoneBook[i].getFirstName() == "John" && pb.phoneBook[i].getLastName() == "Smith"){ // search for the entry
                pb.phoneBook[i].setPhoneNumber("202555555"); // change the phone number
                pb.phoneBook[i].printBookEntry(); // print the entry
                oriZipcode = pb.phoneBook[i].getZipcode(); // save the original zipcode
                break;
            }
        }
        for(int i = 0; i < intIndex; i++){
            if(pb.phoneBook[i].getFirstName() == "James"){
                pb.phoneBook[i].setZipcode(oriZipcode); // change the zipcode
                break;
            }
        }
        sa.close();
    }
}
