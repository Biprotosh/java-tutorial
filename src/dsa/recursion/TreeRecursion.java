package dsa.recursion;

public class TreeRecursion {
    public static void main(String[] args) {
        fun(3);
    }

    // Time -> O(2^n)
    // Space -> O(n)
    public static void fun(int n){
        if(n>0){
            System.out.print(n+" ");
            fun(n-1);
            fun(n-1);
        }
    }
}
