public class Rectangle extends Shape {
    private Point lowerLeft;
    private Point upperRight;

    public Rectangle(Point ll, Point ur) {
        super();
        lowerLeft = ll;
        upperRight = ur;
    }

    @Override
    public boolean isPointIn(Point k){
        int x = k.getX();
        int y = k.getY();
        if(x >= lowerLeft.getX() && x <= upperRight.getX() && y >= lowerLeft.getY() && y <= upperRight.getY()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public double getArea(){
        return (upperRight.getX() - lowerLeft.getX()) * (upperRight.getY() - lowerLeft.getY());
    }

    @Override
    public double getPerimeter(){
        return 2 * (upperRight.getX() - lowerLeft.getX()) + 2 * (upperRight.getY() - lowerLeft.getY());
    }
}

public class Circle extends Shape{
    private Point center;
    private int radius;

    public Circle(Point c, int r){
        super();
        center = c;
        radius = r;
    }

    @Override
    public boolean isPointIn(Point k){
        int x = k.getX();
        int y = k.getY();
        if(Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2) <= Math.pow(radius, 2)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override  
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}