package FunctionalProgramming;

public class FunctionalIntefacesTut {
    public static void main(String[] args) {
        Calculator c1 = new Addition();
        int sum = c1.calculate(5, 7);
        System.out.println(sum);

        // using lamda expression
        print(10, 11, (a, b) -> a+b);
        Calculator c2 = (a, b) -> a * b;
        print(10, 11, c2);
    }

    public static void print(int a, int b, Calculator c){
        System.out.println(c.calculate(a, b));
    }
}

@FunctionalInterface
interface Calculator{
    int calculate(int a, int b);
}

class Addition implements Calculator{

    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}