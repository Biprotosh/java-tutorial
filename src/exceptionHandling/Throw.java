package exceptionHandling;

public class Throw {
    public static void main(String[] args) {
        try{
            checkEligibility(-2);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void checkEligibility(int age){
        if(age < 0)
            throw new IllegalArgumentException("Age cant by negative");

        if(age >= 18)
            System.out.println("You are eligible for voting");
    }
}
