import java.util.*;

public class test{
    public static void main(String[] args){
        show(new cat());
        show(new dog());

        Animal a = new dog();
        a.eat();
        cat c = (cat)a;
        c.eat();
    }
    public static void show(Animal ani){
        ani.eat();
        if (ani instanceof dog){
            dog d = (dog)ani;
            d.work();
        }
        if (ani instanceof cat){
            cat c = (cat)ani;
            c.work();
        }
    }
}
class Animal{
    void eat(){
        System.out.println("I am eating");
    }
}

class dog extends Animal{
    public void eat(){
        System.out.println("I am a dog, I am eating");
    }
    public void work(){
        System.out.println("I am a dog, I am working");
    }
}

class cat extends Animal{
    public void eat(){
        System.out.println("I am a cat, I am eating");
    }
    public void work(){
        System.out.println("I am a cat, I am working");
    }
}