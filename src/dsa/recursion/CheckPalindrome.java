package dsa.recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "112232211";
        System.out.println(check(str, 0, str.length()-1));
    }

    public static boolean check(String str, int s, int e){
        if(s >= e )
            return true;
        else if(str.charAt(s) != str.charAt(e))
            return false;
        else
            return check(str, s+1, e-1);
    }
}
