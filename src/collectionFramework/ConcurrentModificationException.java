package collectionFramework;

import java.util.*;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Iterator<Integer> it = list.iterator();

        // gives ConcurrentModificationException because we changed the list while traversing
        while (it.hasNext()){
            int value = it.next();
            if(value == 3)
//                list.remove(value); // gives the exception
                it.remove(); // doesn't give the exception
            System.out.println(value);
        }
    }
}
