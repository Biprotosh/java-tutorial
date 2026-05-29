package collectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterableTutorial {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next()); // it gives the data and shift to next data
        }
    }
}
