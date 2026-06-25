package oop;

public class Objects {
//    // Volatile variable to hold the global Instrumentation instance
//    private static volatile Instrumentation globalInstrumentation;
//
//    // premain method to initialize the Instrumentation instance
//    public static void premain(String agentArgs, Instrumentation inst) {
//        globalInstrumentation = inst;
//    }
//
//    // Method to get the size of an object
//    public static long getObjectSize(Object object) {
//        if (globalInstrumentation == null) {
//            throw new IllegalStateException("Agent not initialized.");
//        }
//        return globalInstrumentation.getObjectSize(object);
//    }

    public static void main(String[] args) {
        String str = "Biprotosh";

//        System.out.println(getObjectSize(str));

        System.out.println(Integer.BYTES);

        Temp t = new Temp();
//        t.age = 128; // Gives error as byte range -128 to +127
    }
}

class Temp{
    byte age;
}