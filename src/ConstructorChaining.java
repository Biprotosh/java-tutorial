public class ConstructorChaining {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Biprotosh", 25);
        s2.printStudent();
    }
}

class Student{
    String name;
    int roll;
    int age;
    String collegeName;

    // Used chaining method to avoid NULL
    Student(){
        this("Unknown", 0, 0, "Unknown");
    }

    Student(String name){
        this(name, 0, 0, "Unknown");
    }

    Student(String name, int roll){
        this(name, roll, 0, "Unknown");
    }

    Student(String name, int roll, int age){
        this(name, roll, age, "Unknown");
    }

    Student(String name, int roll, int age, String collegeName){
        this.name = name;
        this.roll = roll;
        this.age = age;
        this.collegeName = collegeName;

        // Recursive constructor, constructor calling itself
        // cant even write a base condition as constructor don't have a return type (Note even void)l
//        this(name, roll, age, collegeName);
    }

    void printStudent(){
        System.out.println("Name -> " + name);
        System.out.println("Age -> " + age);
        System.out.println("Roll -> " + roll);
        System.out.println("College name -> " + collegeName);
    }
}
