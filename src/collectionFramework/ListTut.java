package collectionFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListTut {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(1)); // get the value from index 1
        list.set(1, 22); // set the value at index 1 with the value 22
        System.out.println(list);

        list.addAll(0, List.of(9, 8, 7)); // add a collection from index 0
        System.out.println(list);

        list.remove(0); // removes an element from index 0
        System.out.println(list);

        System.out.println(list.indexOf(2)); // prints the index of an element
        System.out.println(list.lastIndexOf(3)); // prints the list index of an element

        // List iterator. we can specify from which index it should listen
        ListIterator<Integer> it = list.listIterator();

        // forward traversal
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // backward traversal
        while (it.hasPrevious()){
            System.out.print(it.previous() + " ");
        }
        System.out.println();

        // Unmodifiable list
        List<Integer> unModList1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(unModList1);
//        unModList.add(33); // gives UnsupportedOperationException

        List<Integer> unModList2 = List.copyOf(unModList1); // also unmodifiable
        System.out.println(unModList2);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.ensureCapacity(10); // creates the array with minimum capacity
        list2.trimToSize(); // frees the unused size
    }
}





















