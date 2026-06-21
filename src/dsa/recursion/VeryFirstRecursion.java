package dsa.recursion;

public class VeryFirstRecursion {
    public static void main(String[] args) {
        fun1(10);
        System.out.println();
        fun2(10);
    }

    // Example of a tail recursion
    public static void fun1(int n){
        if(n>0){
            System.out.print(n + " ");
            fun1(n-1);
        }
    }

    // Example of a head recursion
    public static void fun2(int n){
        if(n>0){
            fun2(n-1);
            System.out.print(n + " ");
        }
    }
}
