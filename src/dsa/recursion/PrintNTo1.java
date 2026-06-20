package dsa.recursion;

public class PrintNTo1 {
    public static void main(String[] args) {
        fun(1, 5);
        System.out.println();
        fun2(1, 5);
    }

    public static void fun(int i, int n) {
        if(n<i) return;
        System.out.print(n + " ");
        fun(i, n-1);
    }

    // using backtrack
    public static void fun2(int i, int n) {
        if(i>n) return;
        fun2(i+1, n);
        System.out.print(i + " ");
    }
}
