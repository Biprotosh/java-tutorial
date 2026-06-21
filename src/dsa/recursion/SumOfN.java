package dsa.recursion;

public class SumOfN {
    public static void main(String[] args) {
        System.out.println(fun(3));
        fun(3, 0);
    }

    public static int fun(int n){
        if(n == 1) return 1;
        else
            return n + fun(n-1);
    }

    public static void fun(int n, int sum){
        if(n < 1){
            System.out.println(sum);
            return;
        }
        else
            fun(n-1, sum+n);
    }
}
