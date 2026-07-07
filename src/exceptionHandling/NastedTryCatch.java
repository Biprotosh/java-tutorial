package exceptionHandling;

public class NastedTryCatch {
    public static void main(String[] args) {
        // inner try handles its exception
//        try{
//            System.out.println("Outer try starts");
//            try{
//                System.out.println("Inner try starts");
//                System.out.println(5/0); // throws exception
//                System.out.println("Inner try end");
//            }
//            catch (ArithmeticException e){
//                System.out.println(e.getMessage()+ ": inner");
//            }
//            System.out.println("Outer try end");
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage() + ": outer");
//        }

        // Outer try handles the exception to inner try block
        // inner try handles its exception
        try{
            System.out.println("Outer try starts");
            try{
                System.out.println("Inner try starts");
                System.out.println(5/0); // throws exception
                System.out.println("Inner try end");
            }
            catch (NullPointerException e){
                System.out.println(e.getMessage()+ ": inner");
            }
            System.out.println("Outer try end"); // this statement won't execute as the inner catch block didn't execute
        }catch (ArithmeticException e){
            System.out.println(e.getMessage() + ": outer");
        }
    }
}

/*
    We can do nested try catch in try block as well as inside catch block as well.
    The exception thrown by inner try can catch by outer catch block
    We avoid nested try catch
 */
