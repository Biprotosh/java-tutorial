package StackProblems;

import java.util.Map;
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        String exp = "15 5 + 10 2 * *"; // input expression

        System.out.println(exp); // printing input expression
        convert(exp);

    }

    public static void convert(String exp){
        String[] arrayOfExp = exp.split(" ");

        Stack<Integer> stk = new Stack<Integer>(); // using stack to store operators
        int i = 0; // for iterating through input expression given by user
        int n = arrayOfExp.length; // length of the expression

        while(i<n){
            String num = arrayOfExp[i]; // storing each character in ch

            if(num.matches("\\d+")) // if ch is an digit push it into stack
                stk.push(Integer.parseInt(num));

            else{
                int secondVal = stk.pop();
                int firstVal = stk.pop();

                stk.push(calculate(num, firstVal, secondVal));
            }

            i++; // incrementing i
        }

        System.out.println("Result -> " + stk.peek());
    }

    static int calculate(String op, int firstVal, int secondVal){
        return switch (op) {
            case "+" -> firstVal + secondVal;
            case "-" -> firstVal - secondVal;
            case "*" -> firstVal * secondVal;
            case "/" -> firstVal / secondVal;
            case "^" -> (int) Math.pow(firstVal, secondVal);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }
}
