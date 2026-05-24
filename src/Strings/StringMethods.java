package Strings;

public class StringMethods {
    public static void main(String[] args) {
        String s1 = "   ";
        System.out.println(s1.length());
        System.out.println(s1.isEmpty()); // count spaces
        System.out.println(s1.isBlank()); // doesn't count spaces

        s1 = "abc";
        String s2 = "abd";

        // Lexicographical comparison -> Dictionary
        // compareTo() -> gives output in -ve (s1 < s2), 0 (s1 == s2), +ve (s1 > s2)
        System.out.println(s1.compareTo(s2));

        s2 = "   hello  ";
        System.out.println(s2.trim() + s1); // remove spaced from front and back
        System.out.println(s2.strip() + s1); // does the same thing like trim() but it is unicode friendly

        String str = "Banana";
        System.out.println(str.replace("an", "tt")); // treats target as literal string
        System.out.println(str.replaceAll("n.n", "(-)")); // treats target as regex (a.b -> a1b, axb etc)

        String[] str2 = {"hi", "jj", "how"};
        System.out.println(String.join("-", str2[0], str2[1]));

        // intern() -> copy the string object from heap to string pool(if the string already exist in string pool then just refer)
        String s3 = new String("XYZ"); // one object will be created at heap, and one will be created at string pool
        String s4 = s3; // s4 points to the object created at heap
        System.out.println(s4 == s3); // true

        s4 = s3.intern(); // s4 points to the object created at string pool
        System.out.println(s4 == s3); // false

        // format
        String name = "Char0_n";
        int age = 23;
        System.out.println("Hello " + name + ", your age is " + age); // without format
        System.out.printf("Hello %s, you age is %s%n", name, age);
    }
}
