package QiuanYu_Homework_7;
import java.util.Scanner;
public class Exercise1 {
    public static Scanner sa = new Scanner(System.in);
    static class PhoneBookEntry{
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
        public PhoneBookEntry(int id, String firstName, String lastName, String email, String phoneNumber, String zipcode){
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
    public static class PhoneBook{
        private PhoneBookEntry[] phoneBook;
        public PhoneBook(){
            phoneBook = new PhoneBookEntry[255];
        }
        public void addBookEntry(PhoneBookEntry bookEntry){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] == null){
                    phoneBook[i] = bookEntry;
                    return;
                }
            }
            System.out.println("Phone book is full!");
        }
        public void deleteBookEntry(int id){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null && phoneBook[i].getId() == id){
                    phoneBook[i] = null;
                    System.out.println("Book deleted successfully!");
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void printBookEntry(int id){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null && phoneBook[i].getId() == id){
                    phoneBook[i].printBookEntry();
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void editfirstName(int id){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null && phoneBook[i].getId() == id){
                    System.out.println("Enter new first name: ");
                    phoneBook[i].setFirstName(sa.nextLine());
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void editlastName(int id){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null && phoneBook[i].getId() == id){
                    System.out.println("Enter new last name: ");
                    phoneBook[i].setLastName(sa.nextLine());
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void editemail(int id){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null && phoneBook[i].getId() == id){
                    System.out.println("Enter new email: ");
                    phoneBook[i].setEmail(sa.nextLine());
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void editphoneNumber(int id){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null && phoneBook[i].getId() == id){
                    System.out.println("Enter new phone number: ");
                    phoneBook[i].setPhoneNumber(sa.nextLine());
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void editzipcode(int id){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null && phoneBook[i].getId() == id){
                    System.out.println("Enter new zipcode: ");
                    phoneBook[i].setZipcode(sa.nextLine());
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void printBookEntry(String firstName, String lastName){
            for(int i = 0; i < phoneBook.length; i++){  // search by first name and last name
                if(phoneBook[i] != null && phoneBook[i].getFirstName().equals(firstName) && phoneBook[i].getLastName().equals(lastName)){
                    phoneBook[i].printBookEntry();
                    return;
                }
            }
            System.out.println("Book not found!");
        }
        public void printAllBookEntry(){
            for(int i = 0; i < phoneBook.length; i++){
                if(phoneBook[i] != null){
                    phoneBook[i].printBookEntry();
                }
            }
        }

    }
    public static void main(String[] args) {
        
        sa.close();
    }
}
