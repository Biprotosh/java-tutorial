package generics;

import java.util.ArrayList;
import java.util.List;

// Generic using lower bound using super
public class WildCardUsingLowerBound {
    public static void main(String[] args) {
        List<Animal1> animals = new ArrayList<>();
        animals.add(new Animal1());
        animals.add(new Animal1());

        fun(animals);
    }

    public static void fun(List<? super Animal1> values){
        // here writing is allowed
        values.add(new Animal1());
        values.add(new Dog1());

        // Reading is not allowed but we can read using typecasting
        for(Object obj: values){
            Animal1 a  = (Animal1) obj;
            a.eat();
        }
    }
}
