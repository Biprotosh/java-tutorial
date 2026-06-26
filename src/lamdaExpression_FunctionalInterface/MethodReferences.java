package lamdaExpression_FunctionalInterface;

import java.util.*;
import java.util.function.*;

public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);

        list.forEach(x -> System.out.println(x));
        System.out.println();
        list.forEach(System.out::println); // using method reference operator

        list.stream()
                .map(Math::sqrt)
                .forEach(System.out::println);

    }
}
