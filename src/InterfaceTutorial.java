public class InterfaceTutorial {
    public static void main(String[] args) {
//        Walkable person = new Human(); // it don't have seat() method, so we cant call seat()
        Seatable person = new Human();
        person.walk();
        person.seat();
        person.eat();
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