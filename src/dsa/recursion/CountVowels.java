package dsa.recursion;

public class CountVowels {
    public static void main(String[] args) {
        String str = "charon";
        System.out.println(count(str, str.length()-1));
    }

    public static int count(String str, int index){
        if(index == -1)
            return 0;
        else if(str.charAt(index) == 'a' || str.charAt(index) == 'e' || str.charAt(index) == 'i' ||
                str.charAt(index) == 'o' || str.charAt(index) == 'u')
            return 1+count(str, index-1);

        else return count(str, index-1);
    }
}
