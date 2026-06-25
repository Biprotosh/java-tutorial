package oop;

public class ImmutableClass {
    public static void main(String[] args) {
        College college = new College("HITK", "Kolkata");
        ExampleStudent student = new ExampleStudent(22, "Biprotosh", college);

        System.out.println(student.getAge());
        System.out.println(student.getName());

        System.out.println(student.getCollege().name);

        // we can change this college properties using student object as getCollege() gives us the reference
        // of college object. That's why student objects is not purely immutable
        student.getCollege().name = "IEM";

        System.out.println(student.getCollege().name);
    }
}

// Immutable (Not purely immutable)
// By creating new object of the reference variable we make it immutable
final class ExampleStudent{
    private final int age;
    private final String name;
    private final College college;

    ExampleStudent(int age, String name, College college){
        this.age = age;
        this.name = name;
//        this.college = college; // instead of directly refer to this.college, we will make a new object of oop.College class
        this.college = new College(college.name, college.address);
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

//    public oop.College getCollege(){
//        return this.college;
//    }

    /**
     * Let's make this class immutable by using Defensive copy
     * where we don't return direct reference of another class
     * but return a reference by making a new object
     */

    public College getCollege() {
        return new College(this.college.name, this.college.address);
    }
}

// Mutable
class College{
    public String name;
    public String address;

    College(String name, String address){
        this.name = name;
        this.address = address;
    }
}
























