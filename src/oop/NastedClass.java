package oop;

public class NastedClass {
    public static void main(String[] args) {
        Outer outer = new Outer(); // outer class
        Outer.Inner inner = new Outer.Inner(); // inner class

        inner.fun();

//        oop.C c = new oop.C();
//        oop.C.D d = c.new D();
        C.D d = new C().new D();

        d.greet();

        E e = new E();
        e.greet();

        Person person = new Person(){
            @Override
            public void introduce(){
                System.out.println("interfaces.Hi, I am a guest");
            }
        };

        person.introduce();
        person.introduce();
    }
}

/**
 *  Static nested class
 *  Properties -
 *      1. Can only access outer class static variables or methods, as static memebers are linked to a class not to an object
 *      2. Inner class can extends another class or implements interfaces
 */

class Outer{

    static void greet(){
        System.out.println("Good morning");
    }

    static class Inner{
        public void fun(){
            greet();
            System.out.println("hello");
        }
    }
}

class BankAccount{

    // Made this class private so that it is invisible outside of oop.BankAccount class
    // And we achieved logical grouping using static nested class
    // Works as a helper class
    private static class InterestCalculator{
        static double calculateYearly(double principle, double rate){
            return principle * rate;
        }

        static double calculateMonthly(double principle, double rate){
            return (principle * rate)/12;
        }
    }

    public double computeInterest(double principle, double rate){
        return InterestCalculator.calculateYearly(principle, rate);
    }
}

// Inner class
class C{
    private int x = 10;
    class D{
        int x = 20;
        public void greet(){
            System.out.println("interfaces.Hello world");
            System.out.println(x);
            System.out.println(C.this.x);
        }
    }
}

// Local class
class E{
    public void greet(){
        int y = 5;
//        y++; // cant modified because if we modify then greet2() won't able to access it

        class Local{
            public void greet2(){
                System.out.println("interfaces.Hello from local");
                System.out.println(y);
            }
        }

        Local local = new Local();
        local.greet2();
    }
}

// Anonymous class
class Person{
    void introduce(){
        System.out.println("interfaces.Hi, I am a person");
    }
}












