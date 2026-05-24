package Strings;

public class StringBuilderTut {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity()); // 16

        sb.append("Char0_n");
        System.out.println(sb.capacity()); // 16, when we consume all the capacity it will increase the capacity ((2*capacity)+2)

        System.out.println(sb.insert(2, '3')); // ch3ar0_n

        sb.trimToSize(); // it removes the unused memory of the buffer
        System.out.println(sb.capacity()); // 8

        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println(sb1.equals(sb2)); // false, StringBuilder/Stringbuffer doesnt override equeals()
        System.out.println(sb1 == sb2); // false
    }
}
