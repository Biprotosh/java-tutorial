package exceptionHandling;

public class ExceptionHandlingTut {
    public static void main(String[] args) {
        int a = 5, b = 0;
//        methodA(a, b);

        // Exception handling

        System.out.println("Step 1");

        try{
            int x = 5, y = 0;
            System.out.println(x/y);
        }catch (ArithmeticException e){
//            System.out.println("Divide by zero not allowed");
            System.out.println(e.getMessage());
        }

        System.out.println("Step 2");
    }

    public static void methodA(int a, int b){
        methodB(a, b);
    }

    public static void methodB(int a, int b){
        System.out.println(a/b);
    }
}

/*
 className.methodName
 Stack trace
       Exception in thread "main" java.lang.ArithmeticException: / by zero
       at exceptionHandling.ExceptionHandlingTut.methodB(ExceptionHandlingTut.java:15)
  	   at exceptionHandling.ExceptionHandlingTut.methodA(ExceptionHandlingTut.java:11)
  	   at exceptionHandling.ExceptionHandlingTut.main(ExceptionHandlingTut.java:7)

  Whenever jvm sees a try block it understands that the code written inside try is a risky code and if the exception
  occurs, jvm tries to find the respective catch block which catches the corresponding exception (for / by zero the exception
  is arithmetic exception) with in the same method. If the method didn't handle it then the jvm searches the parent methods
  whether they handled the exception or not. If the parent method didn't handle it then jvm simply prints the stack trace to the
  console
 */