package collectionFramework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);

        System.out.println(c.size()); // size of the collection
        System.out.println(c.isEmpty()); // is the collection empty
        System.out.println(c.contains(2)); // for array take O(n), for hashset it takes O(1)

        Object[] obj = c.toArray();
        for(Object o : obj)
            System.out.println(o);

        // With Object we don't have much methods to work with so we use toArray(T[])
        // (new Integer[0]) is just a notation to tell toArray() that we want a integer array it takes 0 space in the memory
        Integer[] arr = c.toArray(new Integer[0]);
        for (Integer i : arr)
            System.out.println(i);

        // true, if value is successfully added to the list.
        // if we are using sets where duplicates are not allowed, this methods works well
        boolean b = c.add(4);
        System.out.println(b);

        System.out.println(c.remove(2));

        System.out.println(c.addAll(List.of(5, 6, 7, 8)));
        System.out.println(c);

        System.out.println(c.containsAll(List.of(4, 5)));

        c.removeAll(List.of(3, 4));
        System.out.println(c);

        c.clear(); // removes all the data
        System.out.println(c);
    }
}
