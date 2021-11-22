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
    }
    public static Users[] users = new Users[255];
    public static Project[] projects = new Project[255];
    public static boolean login(String username, String password){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void editUser(int index){
        System.out.println("Please enter the new username: ");
        String username = sa.nextLine();
        System.out.println("Please enter the new password: ");
        String password = sa.nextLine();
        System.out.println("Please enter the new firstname: ");
        String firstname = sa.nextLine();
    }
    public static void main(String[] args) {
        users[0] = new Users("admin", "admin", "admin", "admin", "admin", 1);
        users[1] = new Users("engineer", "engineer", "engineer", "engineer", "engineer", 2);
        users[2] = new Users("financial", "financial", "financial", "financial", "financial", 3);
        projects[0] = new Project("P001", "Project 1", 1000000, 2);
        projects[1] = new Project("P002", "Project 2", 2000000, 2);
        projects[2] = new Project("P003", "Project 3", 3000000, 3);
        String username = sa.nextLine();
        String password = sa.nextLine();
        while(!login(username, password)){
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
        int choice = 0;
        System.out.println("Welcome " + users[0].getFirstname() + " " + users[0].getLastname());
        while(choice != 99){
            System.out.println("1. Edit user info");
            System.out.println("2. List project info");
            choice = sa.nextInt();
            switch(choice){
                case 1:
                    //edituserinfo();
                    break;
                case 2:
                    //listprojectinfo();
                    break;
                default:
                    choice = 99;
                    break;
            }
        }
        sa.close();
    }
}
