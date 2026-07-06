package streams;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        Optional<String> name = getName();
//        System.out.println(name.get()); // get() can throw exception if value is null

//        if(name.isPresent())
//            System.out.println(name.get());

        // better approach
        name.ifPresent(System.out::println);

//        System.out.println(name.orElse("Unknown")); // if name is null then it prints the default value
        System.out.println(name.orElseGet(() -> "Unknown"));
        /**
         * orElse() -> is expensive. even if there is a value it always evaluates the string
         * orElseGet() -> don't evaluate the supplier if value is present. Basically it uses short-circuiting
         * orElseThrow() -> throws exception if the value is null
         */

        name.ifPresentOrElse(System.out::println, () -> System.out.println("Unknown"));
    }

    public static Optional<String> getName(){
//        return Optional.of("John"); // we can pass null here
//        return Optional.empty();
        return Optional.ofNullable(null); // we can pass null value
    }
}
