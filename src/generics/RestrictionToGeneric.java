package generics;

public class RestrictionToGeneric {
    public static void main(String[] args) {
        Restriction<Integer> val = new Restriction<Integer>(10);
        val.getDouble();

//        Restriction<String> val2 = new Restriction<String>("Hslkdkf"); // gives error
        Spices<Fish> s1 = new Spices<Fish>();

    }
}

// T is bounded to only extend number class
// Upperbound -> T is atleast Number or its subtype
class Restriction<T extends Number>{
    public T value;

    Restriction(T value){
        this.value = value;
    }

    public void getDouble(){
        System.out.println(value.doubleValue());
    }
}

// Spices can be only the datatype which extends Animal class and implements Swimmable & Breathable interface
class Spices<T extends Animal & Swimmable & Breathable>{
    public T value;
}

interface Swimmable{
    void swim();
}

interface Breathable{
    void breath();
}

class Animal{
    public void display(){
        System.out.println("Displaying animan");
    }
}

class Dog extends Animal implements Breathable{
    @Override
    public void breath(){
        System.out.println("Animal can breath");
    }
}

class Fish extends Animal implements Swimmable, Breathable{
    public void swim(){
        System.out.println("Animal can swim");
    }

    @Override
    public void breath() {
        System.out.println("Animal can breath");
    }
}














