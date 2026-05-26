package generics;

public class GenericMethods {
    public static void main(String[] args) {
        String y = getRes("how are you");
        System.out.println(y);
        print(12, false); // getting the datatype from values, known as type inference
    }

    public static <T> T getRes(T val){
        return val;
    }

    public static <T, U> void print(T firstVal, U secondVal){
        System.out.println(firstVal + " " + secondVal);
    }
}
