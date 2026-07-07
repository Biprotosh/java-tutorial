package exceptionHandling;

public class HandlingExceptionInChainOfMethods {
    public static void main(String[] args) {
        System.out.println("Step 1");

//        try{
            methodA(9, 0);
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }

        System.out.println("Step 2");
    }

    public static void methodA(int a, int b){
//        try{
//            methodB(a, b);
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }

        methodB(a, b);
        System.out.println("Step 3"); // wont execute. Unreachable line
    }

    public static void methodB(int a, int b){
        try{
            System.out.println(a/b);

            // if exception occurs while executing a/b then HIIIIIIII will not print at all
            // that is why we need finally block
            System.out.println("HIIIIIIII");
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
//            e.printStackTrace(); // prints stack trace even after handling the exception. Maybe needed for logs
        }finally {
            System.out.println("HIIIIIIII");
        }
        System.out.println("Step 4"); // wont execute. Unreachable line
    }
}

/*
    here we can handle the exception in methodB() or any of the parent methods.

    In main() methodA(9, 0) written inside try block so jvm will understand something risky is coming
    methodA() is calling methodB(a/b) and b = 0, so it is illegal and jvm will create new ArithmeticException("/ by zero")
    as the exception is not handled in methodB(), jvm will go to methodA(), exception is also not handled there so it goes to
    main() and it is handled in main().

    When jvm go from methodB() to methodA(), methodB() will be popped from the stack to access methodA()
    and to go from main() to methodA(), methodA() will be popped from the stack too to get access of main()

    If the exception is handled in methodB() only then all the step1, step4, step3, step2 will be printed on screen respectively
    because no methods will be popped from the stack

    finally block always runs no matter whether exception occurs or not. It is optional block;

    catch block is also optional and if there is an exception in try block and there is only finally block then
    the code written in finally will execute. We can write multiple catch blocks and if there is multiple
    catch blocks, jvm finds the appropriate catch in top-to bottom appraoch

    try{
        a/b
    }
    finally{
        sout("Heyy")
    }

    o/p -> Heyy
           stacktrace
 */