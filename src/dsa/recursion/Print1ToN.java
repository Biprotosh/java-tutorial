package dsa.recursion;

public class Print1ToN {
    public static void main(String[] args) {
        fun(1, 5);
        System.out.println();
        fun2(1, 5);
    }

    public static void fun(int i, int n) {
        if(i>n) return;
        System.out.print(i + " ");

//        fun(i++, n); // cause stack overflow because we are using post increment
        fun(++i, n);
    }

    // using backtrack
    public static void fun2(int i, int n){
        if(n < i) return;
        fun2(i, n-1);
        System.out.print(n + " ");
    }
}
