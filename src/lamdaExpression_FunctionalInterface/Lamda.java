package lamdaExpression_FunctionalInterface;

import java.util.*;

public class Lamda {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Doremon", 1, 85));
        list.add(new Student("Nobita", 2, 4));
        list.add(new Student("Schezuka", 3, 95));
        list.add(new Student("Jiyan", 4, 25));

//        Comparator<Student> c1 = new SortByRoll();
        Comparator<Student> c2 = new SortByName();
        Comparator<Student> c3 = new SortByMarks();

        // What we are doing is wrapping the behaviour we want for sorting in a class
        // creating an object of that class then passing it to sort() method
        Collections.sort(list, c3);

        // we can do this using anonymous class, sort by roll
        System.out.println("Sorting by roll");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.roll - o2.roll;
            }
        });

        // using lamda expression, sort by marks. a, b are type of student and java gets it from the type of list
        // list is type of student, so a and b is type of student
        Collections.sort(list, (a, b) -> a.marks - b.marks);

        for (Student s : list){
            s.getter();
        }
    }
}

class SortByName implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class SortByMarks implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.marks - o2.marks;
    }
}

// now are dont need this class as we are using anonymous class for sort list based on roll
//class SortByRoll implements Comparator<Student>{
//    @Override
//    public int compare(Student o1, Student o2) {
//        return o1.roll - o2.roll;
//    }
//}

class Student implements Comparable<Student>{
    String name;
    int roll, marks;

    public Student(String name, int roll, int marks){
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public void getter(){
        System.out.println(roll + ", " + name + ", " + marks);
    }

    // this compareTo() method is tightly coupled to sorting based on only marks
    // but we don't want that, so we can use Comparator
    @Override
    public int compareTo(Student o) {
        return this.marks - o.marks;
    }
}
