package StackProblems;

public class PrefixEvaluation {
    public static void main(String[] args) {
        StringBuilder exp = new StringBuilder("* + 3 4 5");
        exp.reverse();
        PostfixEvaluation.convert(exp.toString());
    }
}
