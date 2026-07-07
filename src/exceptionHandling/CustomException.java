package exceptionHandling;

public class CustomException {
    public static void main(String[] args) {
        try{
            checkEligibility(-82);
        }catch (InvalidAgeException e){
            System.out.println(e.getMessage());
            System.out.println("Entered age was: " + e.getAge());
        }
    }

    private static void checkEligibility(int age){
        if(age < 0)
            throw new InvalidAgeException("Age cant by negative", age);

        if(age >= 18)
            System.out.println("You are eligible for voting");
    }
}

class InvalidAgeException extends RuntimeException{
    private int age;
    public InvalidAgeException(String str, int age){
        super(str);
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}


/*
    We can extend RuntimeException/Exception.
    If we are extending Exception then we have to explicitly specify which type of exception the method is throwing using thorws
    as directly we are extending Excetion class by defalut jvm treat out custome exception as checked/complietimeException
 */