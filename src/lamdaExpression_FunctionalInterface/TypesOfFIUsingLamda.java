package lamdaExpression_FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;


public class TypesOfFIUsingLamda {
    public static void main(String[] args) {
        // Takes an input and gives an output
        Function<Integer, Integer> f = x -> x * x;
        System.out.println(f.apply(5));

        // Takes an input and don't give any output
        Consumer<Integer> c = x -> System.out.println("Accepted number is " + x);
        c.accept(3);

        // Doesn't take any input but gives an output
        Supplier<String> s = () -> "Suppling you the knowladge";
        System.out.println(s.get());

        // Takes an input and returns a boolean
        Predicate<Integer> p = (x) -> x%2==0;
        System.out.println(p.test(5));

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        list.forEach(x -> System.out.println(x)); // printing using forEach and lamda
    }
}
