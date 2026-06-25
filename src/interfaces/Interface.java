package interfaces;

public class Interface {
    public static void main(String[] args) {
        Bird b = new Bird();
        Aeroplane a = new Aeroplane();

        b.start();
        b.fly();
        b.stop();

        a.start();
        a.fly();
        a.stop();
    }
}


interface Flyable{
    void start();
    void fly();
    void stop();
}

class Bird implements Flyable{
    @Override
    public void start(){
        System.out.println("interfaces.Bird is starting");
    }

    @Override
    public void fly(){
        System.out.println("interfaces.Bird is flying");
    }

    @Override
    public void stop(){
        System.out.println("interfaces.Bird is stopped");
    }
}

class Aeroplane implements Flyable{
    @Override
    public void start(){
        System.out.println("interfaces.Aeroplane is starting");
    }

    @Override
    public void fly(){
        System.out.println("interfaces.Aeroplane is flying");
    }

    @Override
    public void stop(){
        System.out.println("interfaces.Aeroplane is stopped");
    }
}