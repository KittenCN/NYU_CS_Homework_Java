package project4;

public class Hiker{
    private int food;
    private int raft;
    private int axe;  
    private boolean isAlive;

    public Hiker(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getRaft() {
        return raft;
    }

    public void setRaft(int raft) {
        this.raft = raft;
    }

    public int getAxe() {
        return axe;
    }

    public void setAxe(int axe) {
        this.axe = axe;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


}
