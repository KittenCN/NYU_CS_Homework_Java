package temp;

public class foo implements Comparable<foo>{
    int x;
    int y;
    public foo(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(foo other){
        int a = this.x*this.x + this.y*this.y;
        int b = other.x*other.x + other.y*other.y;
        return a-b;
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
