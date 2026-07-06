package streams;

import java.util.Optional;

public class OptionalTransformation {
    public static void main(String[] args) {
//        User user = getUser();

        // bad practice
//        if(user != null){
//            Address address = user.address;
//            if(address != null){
//                String city = address.city;
//                if(city != null){
//                    System.out.println(city);
//                }
//            }
//        }

        // more readable than the approach written above
        Optional<User> user = getUser();
//        user.map(x -> x.address)
//                .map(x -> x.city)
//                .ifPresent(System.out::println);

        user.flatMap(x -> x.address)// flatMap converted Optional<Optional<Address>> to Option<Address>
                .map(x -> x.city)
                .ifPresent(System.out::println);


        Optional<String> name = Optional.of("zhello");
        Optional<String> result = name.filter(x -> x.length() > 4);
        System.out.println(result.orElse("Empty"));

        // Alternative
        name.map(x -> x.length()) // using to calculate the length
                .filter(len -> len > 10) // filter out the string on the basis of length
                .ifPresent(System.out::println);

    }

    private static Optional<User> getUser(){
        Address a = new Address();
        a.city = "Delhi";

        User u = new User();
//        u.address = a;
        u.address = Optional.of(a);

//        return u;
        return Optional.of(u);
    }
}

class User{
//    public Address address;
    public Optional<Address> address;
}

class Address {
    public String city;
}

/**
 * Optional is nothing but a mini stream which works on only single value.
 * map()
 * flatMap()
 * filter()
 * all the methods above returns an Optional so that we can use the chaining to do operation in the value
 */
