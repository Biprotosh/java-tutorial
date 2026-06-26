package lamdaExpression_FunctionalInterface;

import java.util.function.*;

public class FunctionalComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> eq = x -> ((x + 2) * 3);

        // ----------Function chaining----------
        Function<Integer, Integer> add2 = x -> x + 2; // f(x)
        Function<Integer, Integer> multiply3 = x -> x * 3; // g(x)
        Function<Integer, Integer> divide2 = x -> x / 2;

        int ans = multiply3.apply(add2.apply(2)); // g(f(x))
        int ans2 = add2.andThen(multiply3).apply(2); // g(f(x))
        int ans3 = add2.andThen(multiply3).andThen(divide2).apply(2);

        System.out.println(ans2);
        System.out.println(ans3);

        int ans4 = add2.compose(multiply3).apply(2); // f(g(x))
        System.out.println(ans4);


        // ----------Predicate chaining----------

        Predicate<Integer> isGreater = x -> x > 100;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isOdd = isEven.negate(); // negate() is not operator

        System.out.println(isGreater
                .and(isEven) // and is AND
                .test(101)
        );

        System.out.println(isGreater
                .or(isEven) // or is OR
                .test(101)
        );

        System.out.println(isOdd.test(54));

        // Real life example
        // Only students whose age >= 18 and marks >= 40 only eligible for a program
        Predicate<Student> isAdult = s -> s.age >= 18;
        Predicate<Student> passingMarks = s -> s.marks >= 40;
        Predicate<Student> isEligible = isAdult.and(passingMarks);

        System.out.println(
                isEligible.test(new Student("kiteretsu", 100, 56, 14))
        );

        // ----------Consumer chaining----------
        Consumer<String> printName = System.out::println;
        Consumer<String> printUpperCase = x -> System.out.println(x.toUpperCase());

        printName.andThen(printUpperCase).accept("charon");

    }
}
