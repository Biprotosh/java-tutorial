package streams;

import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 21, 34, 73));
        // collecting methods
        list.stream()
                .map(x -> x+1)
                .forEach(System.out::println);
                // we also have forEachOrdered() used in parallel stream

        List<Integer> l2 = list.stream()
                .map(x -> x+1)
                .toList(); // it creates an immutable list

        Set<Integer> l3 = list.stream()
                .map(x -> x+1)
                .collect(Collectors.toSet());
//                .collect(Collectors.toList()); // it creates a mutable list. We can collect elements in different collections
        System.out.println(l2);


        // reducing methods -> combine elements in a single value
        Optional<Integer> sum = list.stream() // with the help of Optional class we cant get null pointer exception
                                                // we can use "int sum" to store the reduced value but can get null
                .reduce(1, (a, b) -> a+b).describeConstable(); // identity is the base value, even if list is empty it can print 0
        System.out.println(sum.get());

        long cnt = list.stream()
                .count();
        System.out.println(cnt);

        // we have sum, average, max and min which works with primitive streams
        int sum2 = list.stream()
                .mapToInt(x->x)
                .sum();
        System.out.println(sum2);


        // searching/matching methods
        Optional<Integer> num = list.stream()
                .filter(x -> x>10)
                .findFirst(); // used short-circuiting, after getting the first element the stream terminates
        System.out.println(num.get());

        boolean num2 = list.stream()
                .anyMatch(x -> x%2 == 0); // we also have allMatch(), noneMatch()
        System.out.println(num2);

        // iteration -> here we have forEach() and forEachOrdered()



        // collection() method
        List<String> l1 = List.of("aa", "bbb", "cccc");
        Map<Integer, String> mp = l1.stream()
                                        .collect(Collectors.toMap(
                                                x -> x.length(),
                                                x->x
                                        ));
        System.out.println(mp);

        List<String> l4 = List.of("aa", "bbb", "cccc", "dd", "eee");
        // groupingBy can create n number of groups
        Map<Integer, List<String>> mp2 = l4.stream()
                                                .collect(Collectors.groupingBy(
                                                        x -> x.length()
                                                ));
        System.out.println(mp2);

        // we also have partitioningBy which creates only 2 groups, a true group and a false group
        Map<Boolean, List<Integer>> mp3 = list.stream()
                .collect(Collectors.partitioningBy(x -> x%2 == 0));
        System.out.println(mp3);

        Map<Integer, List<String>> mp4 = l4.stream()
                .collect(Collectors.groupingBy(
                        x -> x.length(),
                        Collectors.mapping(
                                x -> x.toLowerCase(),
                                Collectors.toList()
                        )
                ));
        System.out.println(mp4);

        String str = l4.stream()
                .collect(Collectors.joining("-"));
        System.out.println(str);
    }
}
