package generics;

import java.util.ArrayList;
import java.util.List;

// wildcard with upperbound (extends). it means Atleast the list can by type animal, it is the upper bound
// but can be dog, cat, bird and other animals
public class WildCardUsingUpperBound {
    public static void main(String[] args) {
        List<Dog1> dogs = new ArrayList<>();
        dogs.add(new Dog1());
        dogs.add(new Dog1());

        List<Animal1> animals = new ArrayList<>();
        animals.add(new Animal1());
        animals.add(new Animal1());

        fun(dogs);
        fun(animals);
    }

    public static void fun(List<? extends Animal1> values){
        for(Animal1 animal : values){
            animal.eat();
        }
    }
}
