package dsa.recursion;

public class Table {
    public static void main(String[] args) {
        table(9, 1);
    }

    public static void table(int n, int s){
        if(s==11) return;

        System.out.println(n + "x" + s + "=" + n*s);
        table(n, s+1);
    }
}
