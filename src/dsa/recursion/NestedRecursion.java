package dsa.recursion;

public class NestedRecursion {
    public static void main(String[] args) {
        int x = f(95);
        System.out.println(x);
    }

    public static int f(int n){
        if(n>100)
            return n-10;
        else
            return f(f(n+11));
    }
}
