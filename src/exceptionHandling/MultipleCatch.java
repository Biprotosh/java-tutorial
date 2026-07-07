package exceptionHandling;

public class MultipleCatch {
    public static void main(String[] args) {
        try{
//            System.out.println(5/0); // jvm does new ArithmeticException("/ by zero")

            String s = null;
//            s.length();

            Object greet = "Hello";
            Integer i = (Integer) greet;
        }
//        catch (Exception e){ // gives compiler error
//            System.out.println(e.getMessage());
//        }
        catch (ArithmeticException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Generic exception");
        }
    }
}

/*
    At a time we can only throw one exception.
    Rule :- first we catch specific exceptions then catch the generic exception
    We don't prefer thorwable class as it can catch Error as well as Exception but we only want to catch exception because
    error can't be catched
 */
