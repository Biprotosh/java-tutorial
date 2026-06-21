package dsa.recursion;

public class IndirectRecursion {
    public static void main(String[] args) {
        A(20);
    }

    public static void A(int n){
        if(n>0){
            System.out.print(n + " ");
            B(n-1);
        }
    }

    public static void B(int n){
        if(n>0){
            System.out.print(n + " ");
            A(n/2);
        }
    }
}
