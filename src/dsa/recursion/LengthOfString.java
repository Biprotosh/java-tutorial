package dsa.recursion;

public class LengthOfString {
    static int calLen(String s, int curr, int cnt){
        try{
            char temp = s.charAt(curr);
        }catch (StringIndexOutOfBoundsException e){
            return cnt;
        }

        return calLen(s, curr+1, cnt+1);
    }
}
