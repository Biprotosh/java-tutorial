package oop;

public class Equals {
    public static void main(String[] args) {
        int x = 100, y = 100;

        System.out.println(x == y);

        Integer a = 200, b = 200;

        System.out.println(a == b); // compares references
        System.out.println(a.equals(b)); // compares actual values
        System.out.println(a.intValue() == b.intValue());

        Integer z = a;
        System.out.println(a == z); // ture both the references points to the same object

        a = 127;
        b = 127;

        System.out.println(a == b); // it gives true, because of caching

        Integer e = 100, f = 100;
        System.out.println(e==f);
    }
}
