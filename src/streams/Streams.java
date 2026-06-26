package streams;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 5, 6));

        Stream<Integer> s = list.stream(); // source
        s = s.map(x -> x*x); // intermediate operation
        s.forEach(System.out::println); // terminal operation

        // after terminal operation we cant use the same stream
//        s.forEach(System.out::println);

        String[] str = {"hello", "hi", "bye"};
        Arrays.stream(str)
                .forEach(System.out::println);

        Stream<Integer> st = Stream.of(1, 2, 3, 5);
        st.forEach(System.out::println);

        Stream<Integer> st2 = Stream.empty(); // empty stream

        // Infinite stream
        // iterate() generates stream from a previous value
        // depends on previous value
        Stream.iterate(1, x -> x+1)
                .limit(10) // instead of going infinite we set a limie
                .forEach(System.out::println);

        // generate() generates stream without a previous value
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

    }
}
