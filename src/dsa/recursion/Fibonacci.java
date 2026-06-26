package dsa.recursion;

public class Fibonacci {
    static void fib(int n, int first, int second){
        if(n==2) return;

        int res = first + second;
        System.out.print(res + " ");
        fib(n-1,res - first, res);
    }
}
