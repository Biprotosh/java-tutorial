package streams;

import java.util.*;

public class IntermediateOperation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 21, 34, 73));

        list.stream()
                .filter(x -> x > 10)
                .map(x -> x * 2)
                .forEach(System.out::println);

        List<List<Integer>> list2 = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        list2.stream()
                .flatMap(x -> x.stream())
                .map(y-> y*2)
                .forEach(System.out::println);

        list.stream()
                .peek(System.out::println) // used for debugging. here we are checking elements before sorting
                                            // as forEach() is a terminal operation we cant use sorted() after forEach()
                .sorted()
                .forEach(System.out::println);
    }
}

// sorted() is a stateful operation (meaning it needs all the elements before sorting)
// filter() stateless