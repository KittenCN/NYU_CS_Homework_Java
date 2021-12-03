import java.util.*;
class House{
    int ID;
    double price;
    int Status;  //0: not available for sell, 1: available for sell

    public House(){
        ID = -1;
        price = 0.00;
        Status = 0;
    }
    public House(int ID, double price, int Status){
        this.ID = ID;
        this.price = price;
        this.Status = Status;
    }
    public int getID(){
        return ID;
    }
    public double getPrice(){
        return price;
    }
    public int getStatus(){
        return Status;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setStatus(int Status){
        this.Status = Status;
    }
}

public interface InventoryMng{
    public void Add(House house);
    public void Edit(int id, double price, int status);
    public int delete(int id);
    public House[] HousesBellowPrice(double p);
    public int findMin();
}

class HouseInventory implements InventoryMng{
    ArrayList<House> houses = new ArrayList<House>();
    public void Add(House house){
        houses.add(house);
    }
    public void Edit(int id, double price, int status){
        // Scanner sa = new Scanner(System.in);
        for(House house: houses){
            if(house.getID() == id){
                house.setPrice(price);
                house.setStatus(status);
                // System.out.print("House " + id + " is available for sell or not(enter the 1 or 0): ");
                // int status = sa.nextInt();
                // house.setStatus(status);
            }
        }
        // sa.close();
    }
    public int delete(int id){
        for(House house: houses){
            if(house.getID() == id){
                houses.remove(house);
                return 1;
            }
        }
        return 0;
    }
    public House[] HousesBellowPrice(double p){
        ArrayList<House> housesBellowPrice = new ArrayList<House>();
        for(House house: houses){
            if(house.getPrice() < p){
                housesBellowPrice.add(house);
            }
        }
        House[] housesBellowPriceArray = new House[housesBellowPrice.size()];
        for(int i = 0; i < housesBellowPrice.size(); i++){
            housesBellowPriceArray[i] = housesBellowPrice.get(i);
        }
        return housesBellowPriceArray;
    }
    public int findMin(){
        int min = houses.get(0).getID();
        for(House house: houses){
            if(house.getID() < min){
                min = house.getID();
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        String Menu = "1. Add a house\r\n2. Edit a house\r\n3. Delete a house\r\n4. Display all houses below a certain price\r\n5. Exit\r\n";
        HouseInventory inventory = new HouseInventory();
        int choice = 0;
        while(choice != 5){
            System.out.print(Menu);
            choice = sa.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the ID of the house: ");
                    int id = sa.nextInt();
                    System.out.print("Enter the price of the house: ");
                    double price = sa.nextDouble();
                    System.out.print("Enter the status of the house(enter the 1 or 0): ");
                    int status = sa.nextInt();
                    House house = new House(id, price, status);
                    inventory.Add(house);
                    break;
                case 2:
                    System.out.print("Enter the ID of the house: ");
                    id = sa.nextInt();
                    System.out.print("Enter the price of the house: ");
                    price = sa.nextDouble();
                    System.out.print("House " + id + " is available for sell or not(enter the 1 or 0): ");
                    int intstatus = sa.nextInt();
                    inventory.Edit(id, price, intstatus);
                    break;
                case 3:
                    System.out.print("Enter the ID of the house: ");
                    id = sa.nextInt();
                    if(inventory.delete(id) == 1){
                        System.out.println("House " + id + " is deleted.");
                    }
                    else{
                        System.out.println("House " + id + " is not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the price: ");
                    double p = sa.nextDouble();
                    House[] housesBellowPrice = inventory.HousesBellowPrice(p);
                    for(House houseBellowPrice: housesBellowPrice){
                        System.out.print("ID: " + houseBellowPrice.getID() + " Price: " + houseBellowPrice.getPrice() + " Status: " + (houseBellowPrice.getStatus() == 1 ? "available for sell" : "not available for sell") + "\n");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        sa.close();
    }
}