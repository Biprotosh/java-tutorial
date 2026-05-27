package generics;

import java.util.ArrayList;
import java.util.List;

public class WildCard {
    public static void main(String[] args) {
        List<Dog1> dogs = new ArrayList<>();
        dogs.add(new Dog1());
        dogs.add(new Dog1());
//        fun(dogs); // not allowed as fun() expects a Animal1 type list

        List<Animal1> animals = new ArrayList<>();
        animals.add(new Animal1());
        animals.add(new Animal1());
//        fun(animals); // works fine

        genericFun(animals);
        genericFun(dogs);
    }

    static public void fun(List<Animal1> list){
        for(Animal1 animal : list){
            animal.eat();
        }
    }

    static public void genericFun(List<?> values){
        for(Object obj : values){
//            obj.eat(); // we can only call object specific methods
            System.out.println(obj.getClass().getName());
        }

//        values.add(10); // not allowed as genericFun will know what type of values it is getting at runtime
//        values.add(new Dog1()); // same problem

        // we only read and only using Object class and use Object specific methods

        Object obj = values.get(0);
        Animal1 an = (Animal1) values; // risky code and can get classCastException and runtime error
    }
}
