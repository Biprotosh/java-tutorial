package dsa.recursion;

public class PrintNameNTimes {
    public static void main(String[] args) {
        fun(1, 5);
    }

    public static void fun(int i, int n){
        if(i>n) return;
        System.out.println("Hello");
        fun(i+1, n);
    }
}
