public class Polymorphism {
    public static void main(String[] args) {
        A a = new B();
        a.fun();
        System.out.println(a.x);

        System.out.println(a.getX());
        a = new A();
        System.out.println(a.getX());

        B b = new B();
        b.fun();
        System.out.println(b.x);
        System.out.println(b.getX());
    }
}

class A{
    int x = 20;

    static void fun(){
        System.out.println("From a");
    }

    // both greets are different
    private void greet(){
        System.out.println("Hello from a");
    }

    final void fun2(){
        System.out.println("Dont try to override");
    }

    int getX(){return 20;}
}

class B extends A{
    int x = 40;
    // cant override static methods
    static void fun(){
        System.out.println("From a");
    }

    private void greet(){
        System.out.println("Hello from b");
    }

//    void fun2(){
//        System.out.println("Cant override this method");
//    }

    int getX(){return 40;}
}
