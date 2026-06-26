package dsa.recursion;

public class SumOfDigits {
    static int sumOfDigits(int num){
        if(num == 0)
            return 0;

        return num % 10 + sumOfDigits(num/10);
    }
}
