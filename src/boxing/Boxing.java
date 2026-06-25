package boxing;

public class Boxing {
    public static void main(String[] args) {

        // Autoboxing
        int x = 10;
        Integer y = x; // autoboxing

        System.out.println(x);
        System.out.println(y); // unboxing
        System.out.println(y.intValue());

        // Unboxing
//        Integer a = new Integer(20);
//        Integer a = Integer.valueOf(20);
        Integer a = 20; // autoboxing
        int b = a; // unboxing

        System.out.println(a); // unboxing
        System.out.println(b);

        // using methods
        print(y);

        // using arithmetic operations
        Integer first = 10;
        Integer second = 20;
        int res = first + second;
        System.out.println(res);

        // NullPointerException
        Integer test = null;
        int value = test;
        System.out.println(value);

    }

    static void print(int x){
        System.out.println(x);
    }
}
