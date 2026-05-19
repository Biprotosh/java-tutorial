public class TypeConversion {
    public static void main(String[] args){
        int a = 300;
        System.out.println(a);
        byte b = (byte) a; // 300 % 256 (range of byte)
        System.out.println(b);

        byte n = 50;
        n = (byte) (n * 2);
        System.out.println(n);

        System.out.println(1%32);

        int i = 1;
        System.out.print("After left shift 30 bits: ");
        i <<= 30;
        System.out.println(i);
        System.out.print("After left shift 1 bit (31st bit): ");
        i <<= 1;
        System.out.println(i);
        System.out.println(i == Integer.MIN_VALUE);

    }
}
