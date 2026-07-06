package streams;

import java.util.*;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential stream
        list.stream()
                .map(x -> x*2)
                .forEach(System.out::println);

        System.out.println("------Parallel stream------");
        // Parallel stream. Internally uses multi threading
        list.parallelStream()
                .map(x -> x*2)
//                .forEach(System.out::println); // prints elements unordered
                .forEachOrdered(System.out::println); // it ends parallelism as it waits for all the elements to maintain order
    }
}
