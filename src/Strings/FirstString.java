package Strings;

public class FirstString {
    public static void main(String[] args) {
        // Literal method
        String s1 = "Hello ";
//        s1 = s1.concat("world"); // here s1's is referring to the new object containing "Hello world"
        String s2 = "Hello ";

        // gives true, as it refers to the s1 object as well. Used literal method to unlock string pool feature
        System.out.println(s1 == s2);

        // new method
        String s3 = new String("Nice");
        String s4 = new String("Nice");
        System.out.println(s3 == s4); // gives false, objects made in normal heap, not in heap memory

        String s5 = "ja" + "va";
        String s6 = "java";
        System.out.println(s5 == s6); // true, only compile time strings goes to string pool

        String s7 = "ja";
        String s8 = s7 + "va";
        System.out.println(s7 == s8); // false, runtime/new created string goes to heap

        String s9 = "java";
        System.out.println(s8 == s9); // false, s9 is in string pool but s8 is in heap

        // 2 object will be create, one in heap and one in string pool, because we used literal in the constructor
        String s10 = new String("Whatsapp");
        String s11 = "Whatsapp"; // refers to the existing object in string pool

        // Memory efficiency
        byte[] str = {'j', 'a', 'v', 'a'};
        for(byte i: str){
            System.out.print((char) i);
        }

    }
}
