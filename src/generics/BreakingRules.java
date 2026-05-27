package generics;

import java.util.ArrayList;
import java.util.List;

public class BreakingRules {
    public static void main(String[] args) {
        Animal1 animal = new Dog1(); // allowed, we just can't call bark as it is not in Animal1 class
        animal.eat();
        animal.walk();

        // Invariant in generics
//        List<Dog1> dogs = new ArrayList<Dog1>();
//        List<Animal1> animals = dogs; // not allowed, gives compile time errors

        Dog1[] dogs = new Dog1[10];
        Animal1[] animals = dogs; // allowed, but will give runtime error

        // works fine
        animals[0] = new Dog1();
        animals[1] = new Dog1();
        animals[2] = new Dog1();
        for (Animal1 an: animals){
            if (an == null)
                continue;
            an.eat();
        }

        // gives ArrayStoreException, the problem is it is not generating compile time error
        // it generates a runtime error
        animals[3] = new Animal1();
    }
}

class Animal1{
    public void eat(){
        System.out.println("Eating");
    }

    public void walk(){
        System.out.println("Walking");
    }
}

class Dog1 extends Animal1{
    public void bark(){
        System.out.println("Barking");
    }
}
