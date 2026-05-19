package StackProblems;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String exp = "(a+b)^(c+d)"; // input expression

        System.out.println(exp); // printing input expression

        StringBuilder result = new StringBuilder(); // stores the result
        Stack<Character> stk = new Stack<>(); // using stack to store operators
        int i = 0; // for iterating through input expression given by user
        int n = exp.length(); // length of the expression

        while(i<n){
            char ch = exp.charAt(i); // storing each character in ch

            if(Character.isLetterOrDigit(ch)) // checking if ch is a letter or digit, append it to the result
                result.append(ch);

            else if(ch == '(') // if ch is ( then push a ( into stack
                stk.push('(');

            else if(ch == ')'){ // if ch is ) then pop from stack until ( is encountered
                while(!stk.empty() && stk.peek() != '(')
                    result.append(stk.pop());
                stk.pop(); // pop (
            }

            else{
                // poping from stack until stack is empty or precedence is higher or equal than ch
                while(!stk.empty() && precedence(ch) <= precedence(stk.peek())){
                    result.append(stk.peek());
                }
                stk.push(ch);
            }

            i++; // incrementing i
        }

        while (!stk.empty()) // appending the remaining operators to the result until stack is empty
            result.append(stk.pop());

        System.out.println(result);// printing postfix expression
    }

    static int precedence(char ch){
        if(ch == '^') return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return -1;
    }
}









