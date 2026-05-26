package generics;

public class Upcast_Downcast {
    public static void main(String[] args) {
        // Upcasting
        String s = "hello";
        Object obj = s;
        System.out.println(obj);

        // Downcasting
        Object obj2 = "charon";
//        String s2 = obj2; // we have to do it manually
        String s2 = (String) obj2;
        System.out.println(s2);

        // Dangerous side of downcast
        Object obj3 = 10;
//        String s3 = (String) obj3; // gives ClassCastException
//        System.out.println(s3);

        /*
         * Using general purpose datatype to store multiple type of values using Object class
         * However, we can't perform operations, because Object class is too generic,
         * that it lose its type information.
         * Suppose we want to use (+) operation on the value stored in the value variable of type object ->
         * we can't do that as it works differently with different data type
         * hello + 5 = hello5
         * 6 + 5 = 11
         * true + 5 = (no point)
         */
        Box b1 = new Box(10);
        Box b2 = new Box("Char0_n");
        Box b3 = new Box(true);

//        System.out.println(b1.getValue() + 5); // gives error, we need to do casting manually
        Integer x = (Integer) b1.getValue(); // downcast
        System.out.println(x + 5);
        System.out.println(b3.getValue());
    }
}

// Generic class using Object
class Box{
    private Object value; // have problems

    Box(Object value){
        this.value = value;
    }

    public Object getValue(){
        return value;
    }
}