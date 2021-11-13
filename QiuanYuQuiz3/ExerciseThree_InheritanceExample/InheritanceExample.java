package QiuanYuQuiz3.ExerciseThree_InheritanceExample;
public class InheritanceExample {
    public class Animal {
        private int id;
        private String name;
        private int age;
        public Animal(){
            this.id = 0;
            this.name = "";
            this.age = 0;
        }
        public Animal(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public int getId() {
            return id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setId(int id) {
            this.id = id;
        }
        void eat(){
            System.out.println("Animal is eating");
        }
        protected String toStr() {
            return "Animal id: " + id + " name: " + name + " age: " + age;
        }
    }
    public class Dog extends Animal {
        private String breed;
        public Dog(String name, int age, int id, String breed) {
            super(name, age, id);
            this.breed = breed;
        }
        public Dog(){
            this.breed = "";
        }
        public String getBreed() {
            return breed;
        }
        public void setBreed(String breed) {
            this.breed = breed;
        }
        void eat(){
            System.out.println("Dog is eating");
        }
        void eatT(){
            this.eat();
            super.eat();
        }
        public String toStr() {
            return super.toStr() + " breed: " + breed;
        }
    }
}
