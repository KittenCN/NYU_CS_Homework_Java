public class Penguin { 
    //成员变量 / 属性
    public String name; 
    private int id; 
    //构造函数 / 析构函数
    public Penguin(String name, int  id) { 
        this.name = name; 
        this.id = id; 
    } 
    public Penguin(String name) { 
        this.name = name; 
    }
    //方法
    public void eat(){ 
        System.out.println(name+"正在吃"); 
    }
    public void eat(int num){
        System.out.println(name+"正在吃"+num+"斤鱼");
    }
    public void sleep(){
        System.out.println(name+"正在睡");
    }
    public void introduction() { 
        System.out.println("大家好！我是"         + id + "号" + name + "."); 
    } 
}
