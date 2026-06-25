package oop;

public class Abstraction {
    public static void main(String[] args) {
        Car fc = new FuelCar();
        Car ec = new ElectricCar();

        fc.start();
        fc.accelerate();
        fc.breakCar();

        ec.start();
        ec.accelerate();
        ec.breakCar();
    }
}

abstract class Car{
//    void start(){
//        System.out.println("oop.Car started");
//    }
//
//    void accelerate(){
//        System.out.println("oop.Car accelerate");
//    }
//
//    void breakCar(){
//        System.out.println("Break");
//    }

    abstract void start();
    abstract void accelerate();
    abstract void breakCar();
}

class FuelCar extends Car{
    @Override
    void start(){
        System.out.println("Fuel car started");
    }

    @Override
    void accelerate(){
        System.out.println("Fuel car accelerate");
    }

    @Override
    void breakCar(){
        System.out.println("Fuel car break");
    }
}

class ElectricCar extends Car{
    @Override
    void start(){
        System.out.println("Electric car started");
    }

    @Override
    void accelerate(){
        System.out.println("Electric car accelerate");
    }

    @Override
    void breakCar(){
        System.out.println("Electric car break");
    }
}

















