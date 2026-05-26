package generics;

public class GenericClass {
    public static void main(String[] args) {
        // Using generics -> we can prevent ClassCastException
        // Type argument
        Box2<Integer> newB1 = new Box2<Integer>(10);
        Box2<String> newB2 = new Box2<String>("Nice");
        System.out.println(newB1.getValue() + 10);

        // Using 2 generic types
        Pair<Integer, String> pair = new Pair<Integer, String>(10, "Ten");
        System.out.println(pair.firstValue + " " + pair.secondValue);
    }
}

// General purpose class so that it can work with different data types
// <T> type parameter
class Box2<T>{
    private T value; // have problems

    Box2(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }
}

// We can make more generic class
class Pair<T, U>{
    T firstValue;
    U secondValue;

    Pair(T firstValue, U secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
}
