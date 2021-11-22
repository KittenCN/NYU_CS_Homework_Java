package QiuanYu_Homework_7.HW7Exercise2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
class PhoneBookEntry{
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
        if(id != -1){
            System.out.println("ID: " + id);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Zipcode: " + zipcode);
        }
        
    }
}
class PhoneBookDirectory{
    PhoneBookEntry[] phoneBook = new PhoneBookEntry[10];
    public static Scanner sa = new Scanner(System.in);
    public PhoneBookDirectory(){

    }
    public int addEntry(PhoneBookEntry entry){
        for(int i = 0; i < phoneBook.length; i++){
            if(phoneBook[i] == null){
                phoneBook[i] = entry;
                return i;
            }
        }
        return -1;
    }
    public void printAllPhoneBook(){
        for(int i = 0; i < phoneBook.length; i++){
            if(phoneBook[i] != null){
                phoneBook[i].printBookEntry();
            }
        }
    }
    public int LinearSearchByPhoneNumber(String PhoneNumber){
        for(int i = 0; i < phoneBook.length; i++){
            if(phoneBook[i] != null){
                if(phoneBook[i].getPhoneNumber().equals(PhoneNumber)){
                    return 1;
                }
            }
        }
        return 0;
    }
    public PhoneBookEntry SearchbyIdBinarySearch(int id){
        for(int i = 0; i < phoneBook.length; i++){
            if(phoneBook[i] != null){
                if(phoneBook[i].getId() == id){
                    return phoneBook[i];
                }
            }
        }
        PhoneBookEntry empPBE = new PhoneBookEntry();
        return empPBE;
    }
    public void SortPhoneBook(){
        for(int i = 0; i < phoneBook.length; i++){
            for(int j = 0; j < phoneBook.length - 1; j++){
                if(phoneBook[j] != null && phoneBook[j + 1] != null){
                    if(phoneBook[j].getId() > phoneBook[j + 1].getId()){
                        PhoneBookEntry temp = phoneBook[j];
                        phoneBook[j] = phoneBook[j + 1];
                        phoneBook[j + 1] = temp;
                    }
                }
            }
        }
    }
    public int Edit(String firstName, String lastName){
        for(int i = 0; i < phoneBook.length; i++){
            if(phoneBook[i] != null){
                if(phoneBook[i].getFirstName().equals(firstName) && phoneBook[i].getLastName().equals(lastName)){
                    System.out.println("Enter new id: ");
                    phoneBook[i].setId(sa.nextInt());
                    sa = new Scanner(System.in);
                    System.out.println("Enter new first name: ");
                    phoneBook[i].setFirstName(sa.next());
                    System.out.println("Enter new last name: ");
                    phoneBook[i].setLastName(sa.next());
                    System.out.println("Enter new email: ");
                    phoneBook[i].setEmail(sa.next());
                    System.out.println("Enter new zipcode: ");
                    phoneBook[i].setZipcode(sa.next());
                    System.out.println("Enter new phone number: ");
                    phoneBook[i].setPhoneNumber(sa.next());
                    return 1;
                }
            }
        }
        return 0;
    }
    public int DeleteEntry(int id){
        for(int i = 0; i < phoneBook.length; i++){
            if(phoneBook[i] != null){
                if(phoneBook[i].getId() == id){
                    phoneBook[i] = null;
                    return 0;
                }
            }
        }
        return 1;
    }
    public int DeleteEntry(String firstName, String lastName) {
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i] != null) {
                if (phoneBook[i].getFirstName().equals(firstName) && phoneBook[i].getLastName().equals(lastName)) {
                    phoneBook[i] = null;
                    return 0;
                }
            }
        }
        return 1;
    }
}
class User{
    protected String username;
    protected String password;
    protected PhoneBookDirectory phoneBookDirectory;

    public User(){
        username = "";
        password = "";
        phoneBookDirectory = new PhoneBookDirectory();
    }
    public User(String username, String password, PhoneBookDirectory phoneBookDirectory){
        this.username = username;
        this.password = password;
        this.phoneBookDirectory = phoneBookDirectory;
    }
    public void PrintUserInfo(){
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
class PhoneBookAdmin extends User{
    private String email;
    public PhoneBookAdmin(){
        super();
        email = "";
    }
    public PhoneBookAdmin(String username, String password, String email, PhoneBookDirectory phoneBookDirectory){
        super(username, password, phoneBookDirectory);
        this.email = email;
    }
    public void PrintUserInfo(){
        super.PrintUserInfo();
        System.out.println("Email: " + email);
    }
    public int  AddEntry(PhoneBookEntry entry){
        return phoneBookDirectory.addEntry(entry);
    }
    public int Edit(String firstName, String lastName){
        return phoneBookDirectory.Edit(firstName, lastName);
    }
    public int DeleteEntry(String firstName, String lastName){
        return phoneBookDirectory.DeleteEntry(firstName, lastName);
    }
    public void SortPhoneBook(){
        phoneBookDirectory.SortPhoneBook();
    }
    public int LinearSearchByPhoneNumber(String PhoneNumber){
        return phoneBookDirectory.LinearSearchByPhoneNumber(PhoneNumber);
    }
    public PhoneBookEntry SearchbyIdBinarySearch(int id){
        return phoneBookDirectory.SearchbyIdBinarySearch(id);
    }
    public void ChangePassword(String oldPassword, String newPassword){
        if(password.equals(oldPassword)){
            password = newPassword;
        }
    }
    public void ChangeUserName(String newUsername){
        username = newUsername;
    }
}
class NormalUser extends User{
    private int id;
    public NormalUser(){
        super();
        id = -1;
    }
    public NormalUser(int id, String username, String password, PhoneBookDirectory phoneBookDirectory){
        super(username, password, phoneBookDirectory);
        this.id = id;
    }
    public void PrintUserInfo(){
        super.PrintUserInfo();
        System.out.println("ID: " + id);
    }
    public int addEntry(PhoneBookEntry entry){
        return phoneBookDirectory.addEntry(entry);
    }
    public int Edit(String firstName, String lastName){
        return phoneBookDirectory.Edit(firstName, lastName);
    }
    public void sortPhoneBook(){
        phoneBookDirectory.SortPhoneBook();
    }
    public int LinearSearchByPhoneNumber(String PhoneNumber){
        return phoneBookDirectory.LinearSearchByPhoneNumber(PhoneNumber);
    }
}   
class PhoneBookApplication{
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        File directory = new File("");
        //File directory = new File("QiuanYu_Homework_7");
        Path adminpath = Paths.get(directory.getAbsolutePath() + "/HW7Exercise2/admin.txt");
        Path userpath = Paths.get(directory.getAbsolutePath() + "/HW7Exercise2/user.txt");
        PhoneBookAdmin[] admin = new PhoneBookAdmin[255];
        NormalUser[] user = new NormalUser[255];
        int adminIndex = 0;
        int userIndex = 0;
        try {
            Scanner adminsa = new Scanner(adminpath);
            Scanner usersa = new Scanner(userpath);
            while(adminsa.hasNextLine()){
                //process each line
                String[] line = adminsa.nextLine().split(",");
                admin[adminIndex] = new PhoneBookAdmin(line[0], line[1], line[2], new PhoneBookDirectory());
                adminIndex++;
            }
            while(usersa.hasNextLine()){
                //process each line
                String[] line = usersa.nextLine().split(",");
                user[userIndex] = new NormalUser(Integer.parseInt(line[0]), line[1], line[2], new PhoneBookDirectory());
                userIndex++;
            }               
            adminsa.close();
            usersa.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean isAdmin = false;
        Boolean isUser = false;
        while(!isAdmin && !isUser){
            //login
            System.out.println("Enter username: ");
            String username = sa.nextLine();
            System.out.println("Enter password: ");
            String password = sa.nextLine();
            //check if username is admin
            for(int i = 0; i <= adminIndex; i++){
                if(admin[i] != null){
                    if(admin[i].username.equals(username) && admin[i].password.equals(password)){
                        isAdmin = true;
                        int choice = 0;
                        while(choice != 9){
                            System.out.println("Welcome Admin!");
                            System.out.println("1. Add entry");
                            System.out.println("2. Edit entry");
                            System.out.println("3. Delete entry");
                            System.out.println("4. Sort phone book");
                            System.out.println("5. Search by phone number");
                            System.out.println("6. Search by id");
                            System.out.println("7. Change password");
                            System.out.println("8. Change username");
                            System.out.println("9. Logout");
                            choice = sa.nextInt();
                            switch(choice){
                                case 1:
                                    System.out.println("Enter id: ");
                                    int id = sa.nextInt();
                                    System.out.println("Enter first name: ");
                                    String firstName = sa.next();
                                    System.out.println("Enter last name: ");
                                    String lastName = sa.next();
                                    System.out.println("Enter email: ");
                                    String email = sa.next();
                                    System.out.println("Enter zipcode: ");
                                    String zipcode = sa.next();
                                    System.out.println("Enter phone number: ");
                                    String phoneNumber = sa.next();
                                    PhoneBookEntry entry = new PhoneBookEntry(id, firstName, lastName, email, zipcode, phoneNumber);
                                    admin[i].AddEntry(entry);
                                    break;
                                case 2:
                                    System.out.println("Enter first name: ");
                                    firstName = sa.next();
                                    System.out.println("Enter last name: ");
                                    lastName = sa.next();
                                    admin[i].Edit(firstName, lastName);
                                    break;
                                case 3:
                                    System.out.println("Enter first name: ");
                                    firstName = sa.next();
                                    System.out.println("Enter last name: ");
                                    lastName = sa.next();
                                    admin[i].DeleteEntry(firstName, lastName);
                                    break;
                                case 4:
                                    admin[i].SortPhoneBook();
                                    break;
                                case 5:
                                    System.out.println("Enter phone number: ");
                                    phoneNumber = sa.next();
                                    if(admin[i].LinearSearchByPhoneNumber(phoneNumber) == 1){
                                        System.out.println("Phone number found!");
                                    }
                                    else{
                                        System.out.println("Phone number not found!");
                                    }
                                    break;
                                case 6: 
                                    System.out.println("Enter id: ");
                                    id = sa.nextInt();
                                    admin[i].SearchbyIdBinarySearch(id).printBookEntry();
                                    break;
                                case 7:
                                    System.out.println("Enter old password: ");
                                    String oldPassword = sa.next();
                                    System.out.println("Enter new password: ");
                                    String newPassword = sa.next();
                                    admin[i].ChangePassword(oldPassword, newPassword);
                                    break;
                                case 8: 
                                    System.out.println("Enter new username: ");
                                    String newUsername = sa.next();
                                    admin[i].ChangeUserName(newUsername);
                                    break;
                                case 9:
                                    System.out.println("Logout successfully!");
                                    break;
                                default:    
                                    System.out.println("Invalid choice!");
                                    break;
                            }
                        }
                    }       
                }
            }  
            //check if username is user
            if(!isAdmin){
                for(int i = 0; i <= userIndex; i++){
                    if(user[i] != null){
                        if(user[i].username.equals(username) && user[i].password.equals(password)){
                            isUser = true;
                            int choice = 0;
                            while(choice != 5){
                                System.out.println("Welcome User!");
                                System.out.println("1. Add entry");
                                System.out.println("2. Edit entry");
                                System.out.println("3. Sort phone book");
                                System.out.println("4. Search by phone number");
                                System.out.println("5. Logout");
                                choice = sa.nextInt();
                                switch(choice){
                                    case 1:
                                        System.out.println("Enter id: ");
                                        int id = sa.nextInt();
                                        System.out.println("Enter first name: ");
                                        String firstName = sa.next();
                                        System.out.println("Enter last name: ");
                                        String lastName = sa.next();
                                        System.out.println("Enter email: ");
                                        String email = sa.next();
                                        System.out.println("Enter zipcode: ");
                                        String zipcode = sa.next();
                                        System.out.println("Enter phone number: ");
                                        String phoneNumber = sa.next();
                                        PhoneBookEntry entry = new PhoneBookEntry(id, firstName, lastName, email, zipcode, phoneNumber);
                                        user[i].addEntry(entry);
                                        break;
                                    case 2:
                                        System.out.println("Enter first name: ");
                                        firstName = sa.next();
                                        System.out.println("Enter last name: ");
                                        lastName = sa.next();
                                        user[i].Edit(firstName, lastName);
                                        break;
                                    case 3:
                                        user[i].sortPhoneBook();
                                        break;
                                    case 4:
                                        System.out.println("Enter phone number: ");
                                        phoneNumber = sa.next();
                                        if(user[i].LinearSearchByPhoneNumber(phoneNumber) == 1){
                                            System.out.println("Phone number found!");
                                        }
                                        else{
                                            System.out.println("Phone number not found!");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Logout successfully!");
                                        break;
                                    default:    
                                        System.out.println("Invalid choice!");
                                        break;
                                }
                            }
                        }
                    }
                }
            } 
            //if username or password is wrong
            if(!isAdmin && !isUser){
                System.out.println("Invalid username or password!");
            }
        } 
        sa.close();              
    } 
}