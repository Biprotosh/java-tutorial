package collectionFramework;

import java.util.*;

public class ComparableInterface {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("Bheem", 95));
        list.add(new Student("Raju", 88));
        list.add(new Student("Jaggu", 74));
        list.add(new Student("Ahmud", 95));

        Collections.sort(list); // won't work as java doesn't know how to sort this class

        for (Student s: list){
            s.getter();
        }

        // Data Loss example (Danger of 0)
        Student s1 = new Student("John", 88);
        Student s2 = new Student("Phil", 88);

        TreeSet<Student> set = new TreeSet<>();
        set.add(s1);
        set.add(s2);

        // gives 1 as CompareTo() only compares marks and this.marks - o.marks gives 0.
        // and 0 means both the objects are equal but in reality it is not, so we are facing data loss
        // so, we can use the complex compareTo() logic, if marks are equal then compare names.
        // and it is developers responsibility to say when we 2 objects are equal and when it is not
        System.out.println(set.size());
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int marks;

    public Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    public void getter(){
        System.out.println(name + ", " + marks);
    }

    @Override
    public int compareTo(Student o) {
        return this.marks - o.marks; // compare base on marks

        // if marks are same then print the details based on lexicographical order
//        if(this.marks != o.marks)
//            return this.marks - o.marks;
//        else return this.name.compareTo(o.name); // calling string's compareTo()
    }
}
