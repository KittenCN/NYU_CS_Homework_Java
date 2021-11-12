package QiuanYuQuiz3.ExerciseOne_BookMng;
import java.util.Scanner;
public class BookMng {
    public static Scanner sa = new Scanner(System.in);
    public static String splitline = "--------------------------";
    static class Book{
        private String name;
        private int ISBN;
        private double price;

        public Book(){
            name = "";
            ISBN = 0;
            price = 0.00;
        }
        public Book(String name, int ISBN, double price){
            this.name = name;
            this.ISBN = ISBN;
            this.price = price;
        }
        public String getName(){
            return name;
        }
        public int getISBN(){
            return ISBN;
        }
        public double getPrice(){
            return price;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setISBN(int ISBN){
            this.ISBN = ISBN;
        }
        public void setPrice(double price){
            this.price = price;
        }
    }
    public static Book Books[] = new Book[255];
    public static int showMenu(){
        System.out.println(splitline);
        String menu = "1. Add a Book\r\n2. Delete a Book (by ISBN)\r\n3. Search for a Book\r\n4. Edit a Book Info (the user will enter the ISBN to search for the book to edit)\r\n5. Display ALL books\r\n6. Display ALL books that are below a certain price (price entered by the user)\r\n7. Exit";
        System.out.println(menu);
        System.out.println(splitline);
        System.out.print("Enter your select: ");
        int select = sa.nextInt();
        while(select < 1 || select > 7){
            System.out.println("Invalid input, please enter again: ");
            select = sa.nextInt();
        }
        return select;
    }
    public static void addBook(){
        System.out.println(splitline);
        System.out.println("Enter the name of the book: ");
        String name = sa.nextLine();
        name = sa.nextLine();
        System.out.println("Enter the ISBN of the book: ");
        int ISBN = sa.nextInt();
        while(ISBN < 0){
            System.out.println("Invalid input, please enter again: ");
            ISBN = sa.nextInt();
        }
        while(checkISBN(ISBN)){
            System.out.println("The ISBN is already existed, please enter again: ");
            ISBN = sa.nextInt();
        }
        System.out.println("Enter the price of the book: ");
        double price = sa.nextDouble();
        while(price < 0){
            System.out.println("Invalid input, please enter again: ");
            price = sa.nextDouble();
        }
        for(int i = 0; i < Books.length; i++){
            if(Books[i] == null){
                Books[i] = new Book(name, ISBN, price);
                System.out.println("Book added successfully!");
                return;
            }
        }
        System.out.println("Book not added, the array is full!");
    }
    public static void deleteBook(){
        System.out.println(splitline);
        System.out.print("Enter the ISBN you want to delete: ");
        int ISBN = sa.nextInt();
        for(int i = 0; i < Books.length; i++){
            if(Books[i] != null && Books[i].getISBN() == ISBN){
                Books[i] = null;
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
    public static void searchBook(){
        System.out.println(splitline);
        System.out.print("Enter the ISBN you want to search: ");
        int ISBN = sa.nextInt();
        for(int i = 0; i < Books.length; i++){
            if(Books[i] != null && Books[i].getISBN() == ISBN){
                System.out.println("Book found!");
                System.out.println("Name: " + Books[i].getName());
                System.out.println("ISBN: " + Books[i].getISBN());
                System.out.println("Price: " + Books[i].getPrice());
                return;
            }
        }
        System.out.println("Book not found!");
    }
    public static void searchBook(int ISBN){
        System.out.println(splitline);
        for(int i = 0; i < Books.length; i++){
            if(Books[i] != null && Books[i].getISBN() == ISBN){
                System.out.println("Book found!");
                System.out.println("Name: " + Books[i].getName());
                System.out.println("ISBN: " + Books[i].getISBN());
                System.out.println("Price: " + Books[i].getPrice());
                System.out.println("");
                return;
            }
        }
        System.out.println("Book not found!");
    }
    public static boolean checkISBN(int ISBN){
        for(int i = 0; i < Books.length; i++){
            if(Books[i] != null && Books[i].getISBN() == ISBN){
                return true;
            }
        }
        return false;
    }
    public static void editBook(){
        System.out.println(splitline);
        System.out.print("Enter the ISBN you want to edit: ");
        int ISBN = sa.nextInt();
        for(int i = 0; i < Books.length; i++){
            if(Books[i] != null && Books[i].getISBN() == ISBN){
                searchBook(ISBN);
                System.out.println("");
                System.out.println("Enter the new name of the book: ");
                String name = sa.nextLine();
                name = sa.nextLine();
                System.out.println("Enter the new ISBN of the book: ");
                int newISBN = sa.nextInt();
                while(newISBN < 0){
                    System.out.println("Invalid input, please enter again: ");
                    newISBN = sa.nextInt();
                }
                while(checkISBN(newISBN)){
                    System.out.println("The ISBN is already existed, please enter again: ");
                    newISBN = sa.nextInt();
                }
                System.out.println("Enter the new price of the book: ");
                double price = sa.nextDouble();
                while(price < 0){
                    System.out.println("Invalid input, please enter again: ");
                    price = sa.nextDouble();
                }
                Books[i].setName(name);
                Books[i].setISBN(newISBN);
                Books[i].setPrice(price);
                System.out.println("Book edited successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
    public static void displayAllBooks(){
        System.out.println(splitline);
        for(int i = 0; i < Books.length; i++){
            if(Books[i] != null){
                System.out.println("Name: " + Books[i].getName());
                System.out.println("ISBN: " + Books[i].getISBN());
                System.out.println("Price: " + Books[i].getPrice());
                System.out.println("");
            }
        }
    }
    public static void displayAllBooksBelowPrice(){
        System.out.println(splitline);
        System.out.print("Enter the price you want to display: ");
        double price = sa.nextDouble();
        for(int i = 0; i < Books.length; i++){
            if(Books[i] != null && Books[i].getPrice() < price){
                System.out.println("Name: " + Books[i].getName());
                System.out.println("ISBN: " + Books[i].getISBN());
                System.out.println("Price: " + Books[i].getPrice());
                System.out.println("");
            }
        }
    }
    public static void main(String[] args) {
        boolean exitFlag = false;
        while(!exitFlag){
            switch(showMenu()){
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    editBook();
                    break;
                case 5:
                    displayAllBooks();
                    break;
                case 6:
                    displayAllBooksBelowPrice();
                    break;
                default:
                    exitFlag = true;
                    break;
            }
        }
        sa.close();
    }
}
