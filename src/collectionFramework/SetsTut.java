package collectionFramework;

import java.util.*;

public class SetsTut {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Char0_n");
        set.add("Noha");
        set.add("Aditya");
        set.add("Rohit");

        System.out.println(set.contains("Aditya")); // does search at O(1)

        Map<Integer, String> map = new HashMap<>();
        map.put(101, "Char0_n");
        map.put(102, "Noha");
        map.put(103, "Aditya");
        map.put(104, "Rohit");

        System.out.println(map.containsKey(101)); // does search at O(1)
        System.out.println(map.get(102)); // does search at O(1)
    }
}
