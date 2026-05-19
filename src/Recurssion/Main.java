package Recurssion;

import StackProblems.PostfixEvaluation;

public class Main {
    public static void main(String[] args) {
        int res = SumOfDigits.sumOfDigits(123);
        System.out.println(res);

        int[] arr = {1, 2, 3, 4};
        ReverseArray.reverse(arr, 0, arr.length-1);
        for(int i:arr)
            System.out.print(i + " ");
        System.out.println();

        System.out.println(LengthOfString.calLen("Hello", 0, 0));

        System.out.print("0 1 ");
        Fibonacci.fib(8, 0, 1);
        System.out.println();

        System.out.println(Gcd.gcd(24, 18));

        System.out.println(PowerOfTwoNumber.cal(2, -3));
    }
}
