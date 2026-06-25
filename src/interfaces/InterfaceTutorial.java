package interfaces;

public class InterfaceTutorial {
    public static void main(String[] args) {
//        interfaces.Walkable person = new interfaces.Human(); // it don't have seat() method, so we cant call seat()
        Seatable person = new Human();
        person.walk();
        person.seat();
        person.eat();

        // Solving diamond problem using interface
        X xyz = new XYZ();
        xyz.fun();

        // Resolution priority
        Hi h = new Hi();
        h.fun();
    }
}

interface Walkable{
    void walk();
}

interface Seatable extends Walkable{
    void seat();
    default void eat(){ // we can also override this method
        System.out.println("Can eat");
    }
}

interface MathConstants{
    double PI_VALUE = 3.14;
}

class Human implements Seatable, MathConstants{
    public void seat(){
        System.out.println("Seat\n" + PI_VALUE);
    }

    public void walk(){
        System.out.println("Walking");
    }
}


// Solving diamond problem using interface
interface X {
    void fun();
}

interface Y extends X{
//    void fun();

    @Override
    default void fun(){
        System.out.println("interfaces.Interface interfaces.Y");
    }
}

interface Z extends X{
//    void fun();

    @Override
    default void fun(){
        System.out.println("interfaces.Interface interfaces.Z");
    }
}

class XYZ implements Y,Z{
    @Override
    public void fun(){
//        System.out.println("Default Implementation");

        // want to use oop.B/C implementation
        Y.super.fun();
        Z.super.fun();
    }
}

class Hello {
    public void fun(){
        System.out.println("Inside interfaces.Hello class");
    }
}

class Hi extends Hello implements Z{
    // if we call fun() and both the interface and class has the duplicate method then java gives the priority to extended class's implementation
}