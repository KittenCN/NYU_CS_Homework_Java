package quiz4;
import java.util.*;
public class quiz4 {
    public static Scanner sa = new Scanner(System.in);
    public static class Users{
        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private String id;
        private int permission; //0: normal user, 1: admin, 2: engineer, 3: financial analyst

        public Users(){
            this.username = "";
            this.password = "";
            this.firstname = "";
            this.lastname = "";
            this.id = "";
            this.permission = 0;
        }
        public Users(String username, String password, String firstname, String lastname, String id, int permission) {
            this.username = username;
            this.password = password;
            this.firstname = firstname;
            this.lastname = lastname;
            this.id = id;
            this.permission = permission;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }   
        public void setPassword(String password) {
            this.password = password;
        }
        public String getFirstname() {
            return firstname;
        }
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public int getPermission() {
            return permission;
        }
        public void setPermission(int permission) {
            this.permission = permission;
        }
        public void changePassword(){
            sa = new Scanner(System.in);
            System.out.println("Enter your new password: ");
            String newPassword = sa.nextLine();
            this.password = newPassword;
        }
        public void changeUsername(){
            sa = new Scanner(System.in);
            System.out.println("Enter your new username: ");
            String newUsername = sa.nextLine();
            this.username = newUsername;
        }
    }
    public static class Project{
        private String projectid;
        private String projectname;
        private double projectbudget;
        private int projecttype;

        public Project(){
            this.projectid = "";
            this.projectname = "";
            this.projectbudget = 0;
            this.projecttype = 0;
        }
        public Project(String projectid, String projectname, double projectbudget, int projecttype) {
            this.projectid = projectid;
            this.projectname = projectname;
            this.projectbudget = projectbudget;
            this.projecttype = projecttype;
        }
        public String getProjectid() {
            return projectid;
        }
        public void setProjectid(String projectid) {
            this.projectid = projectid;
        }
        public String getProjectname() {
            return projectname;
        }
        public void setProjectname(String projectname) {
            this.projectname = projectname;
        }
        public double getProjectbudget() {
            return projectbudget;
        }
        public void setProjectbudget(double projectbudget) {
            this.projectbudget = projectbudget;
        }
        public int getProjecttype() {
            return projecttype;
        }
        public void setProjecttype(int projecttype) {
            this.projecttype = projecttype;
        }        
        public void printProject(){
            System.out.println("Project ID: " + this.projectid);
            System.out.println("Project Name: " + this.projectname);
            System.out.println("Project Budget: " + this.projectbudget);
            System.out.println("Project Type: " + this.projecttype);
        }
    }
    public static Users[] users = new Users[255];
    public static Project[] projects = new Project[255];
    public static int login(String username, String password){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        users[0] = new Users("admin", "admin", "admin", "admin", "admin", 1);
        users[1] = new Users("engineer", "engineer", "engineer", "engineer", "engineer", 2);
        users[2] = new Users("financial", "financial", "financial", "financial", "financial", 3);
        projects[0] = new Project("P001", "Project 1", 1000000, 2);
        projects[1] = new Project("P002", "Project 2", 2000000, 2);
        projects[2] = new Project("P003", "Project 3", 3000000, 3);
        System.out.print("Enter Username:");
        String username = sa.nextLine();
        System.out.print("Enter Password:");
        String password = sa.nextLine();
        while(login(username, password) == -1){
            int tmp = 0;
            System.out.println("Invalid username or password");
            username = sa.nextLine();
            password = sa.nextLine();
            tmp++;
            if(tmp == 3){
                System.out.println("Too many attempts, program will exit");
                System.exit(0);
            }
        }
        int userIndex = login(username, password);
        int choice = 0;
        System.out.println("Welcome " + users[userIndex].getFirstname() + " " + users[userIndex].getLastname());
        while(choice != 99 && (users[userIndex].getPermission() == 2 || users[userIndex].getPermission() == 3)){
            System.out.println("1. Change username");
            System.out.println("2. Change password");
            System.out.println("3. List project info");
            System.out.println("4. Quit");
            choice = sa.nextInt();
            switch(choice){
                case 1:
                    users[userIndex].changeUsername();
                    break;
                case 2:
                    users[userIndex].changePassword();
                    break;
                case 3:
                    for(int i = 0; i < projects.length; i++){
                        if(projects[i] != null){
                            if(projects[i].getProjecttype() == users[userIndex].getPermission()){
                                System.out.println("Project ID: " + projects[i].getProjectid());
                                System.out.println("Project Name: " + projects[i].getProjectname());
                                System.out.println("Project Budget: " + projects[i].getProjectbudget());
                                System.out.println("Project Type: " + projects[i].getProjecttype());
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Goodbye");
                    choice = 99;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        sa.close();
    }
}
