package bitwiseOperator;

public class BitWise {
    public static void main(String[] args){

        // left shift
        int i = 1;
        System.out.print("After left shift 30 bits: ");
        i <<= 30;
        System.out.println(i);
        System.out.print("After left shift 1 bit (31st bit): ");
        i <<= 1;
        System.out.println(i);
        System.out.println(i == Integer.MIN_VALUE);

        // right shift
        byte b = 8;
        System.out.print("After 1 bit right shift: ");
        b >>= 1;
        System.out.println(b);

        b = -8;
        System.out.print("After 1 bit right shift: ");
        b >>= 3;
        System.out.println(b);
    }
}
