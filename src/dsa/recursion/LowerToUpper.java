package dsa.recursion;

public class LowerToUpper {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("charon");
        convert(str, str.length()-1);
        System.out.println(str);
    }

    // formula for R from r = 'A' + 'r' - 'a'
    public static void convert(StringBuffer str, int index){
        if(index == -1) return;
        char ch = (char) ('A' + str.charAt(index) - 'a');
        str.setCharAt(index, ch);
        convert(str, index-1);
    }
}
