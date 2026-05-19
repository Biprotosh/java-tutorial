package ObjectClass;

import javax.naming.BinaryRefAddr;
import java.util.Objects;

public class ObjectClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        ExampleStudent s1 = new ExampleStudent();
        s1.name = "John";
        s1.age = 22;

        // toString() method
        System.out.println(s1.toString());
        System.out.println(s1); // println by default prints toString() method

        // equals() method
        ExampleStudent s2 = new ExampleStudent();
        s2.name = "John";
        s2.age = 22;
        System.out.println(s1.equals(s2));

        ExampleStudent s3 = null;
        Integer i = 28;
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(i));

        // hashCode() method
        System.out.println(s1.equals(s2)); // true, but hashCode is different and it is wrong in java
        System.out.println(s1.hashCode() == s2.hashCode());

        // getClass()
        System.out.println(s1.getClass().getName());

        // instanceof operator tells whether an object is an instance of a class or not
        System.out.println(s1 instanceof ExampleStudent); // prints true

        Animal a = new Animal();
        Animal b = new Bird();

        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());

        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Bird);
        System.out.println(b instanceof Animal);

        ExampleStudent newStudent = (ExampleStudent) s1.clone();
        System.out.println(newStudent.name);
        System.out.println(newStudent.age);

        newStudent.name = "XYZ";
        System.out.println(newStudent.name);
    }
}

class ExampleStudent implements Cloneable{
    String name;
    int age;

    @Override
    public String toString() {
        return "ExampleStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false; // preventing NullPointerException by checking obj is null
        if(this == obj) return true; // if both the reference is same then the values are also true
        if(this.getClass() != obj.getClass()) return false; // checks both the classes are same type, preventing ClassCastExceptions

        ExampleStudent s = (ExampleStudent) obj;
        return (Objects.equals(this.name, s.name) && this.age == s.age);
    }

    @Override
    public int hashCode(){
//        int res = 17; // generating hashcode using prime number, generally uses 17
//        res = res * 31 + age;
//        return res * 31 + ((name == null) ? 0 : name.hashCode()); // preventing if name is null

        return Objects.hash(name, age); // does the same thing
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class Animal{

}

class Bird extends Animal{

}