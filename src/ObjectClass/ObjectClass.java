package ObjectClass;

public class ObjectClass {
    public static void main(String[] args) {
        ExampleStudent s1 = new ExampleStudent();

//        System.out.println(s1.toString());
        System.out.println(s1); // println by default prints toString() method
    }
}

class ExampleStudent {
    String name;
    int age;

    @Override
    public String toString() {
        return "ExampleStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}