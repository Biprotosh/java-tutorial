public class TrickyAbstraction {
    public static void main(String[] args) {
        Animal dog = new Dog("Piku");
        dog.makeSound();
    }
}

abstract class Animal{
    private String name;

    Animal(){
        System.out.println("Parent constructor");
    }

    Animal(String name){
        this.name = name;
    }

    abstract public void makeSound();
}

class Dog extends Animal{

    Dog(String name){
        super(name);
    }

    public void makeSound(){
        System.out.println("Barking");
    }
}