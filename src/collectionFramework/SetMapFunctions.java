package collectionFramework;

import java.util.HashSet;
import java.util.*;

public class SetMapFunctions {
    public static void main(String[] args) {
        // Sets
        System.out.println("------ SET ------");

        Set<Integer> set = new HashSet<>(); // default size 16
        Set<Integer> set2 = new HashSet<>(50); // with initial capacity
        Set<Integer> set3 = new HashSet<>(50, 0.8f); // with initial capacity and loadfactor
        Set<Integer> set4 = new HashSet<>(List.of(1,2,3,4,5,6,7));

        // Tree set
        TreeSet<Integer> tset = new TreeSet<>();
        tset.add(80);
        tset.add(23);
        tset.add(90);
        tset.add(50);
        tset.add(10);

        // SortedSet interface methods. Complexity - O(logn)
        System.out.println(tset.first());
        System.out.println(tset.last());
        System.out.println(tset.headSet(80)); // returns smaller values exclusive.
        System.out.println(tset.tailSet(80)); // returns larger values inclusive.
        System.out.println(tset.subSet(23, 80));

        // Navigable set
        System.out.println(tset.lower(80)); // returns largest number smaller than 80
        System.out.println(tset.floor(80)); // returns largest number smaller or equal to 80
        System.out.println(tset.higher(80)); // returns smallest number greater than 80
        System.out.println(tset.ceiling(80)); // returns smallest number greater or equal to 80

        System.out.println(tset.descendingSet());

        // Maps
        System.out.println("------ MAP ------");

        Map<Integer, String> map = new HashMap<>();
        map.put(100, "Aditya");
        map.put(101, "Rohan");
        map.put(102, "Tuntun");

        System.out.println(map.size());
        System.out.println(map.containsKey(101)); // takes O(1)
        System.out.println(map.containsValue("Tuntun")); // takes O(n)
        System.out.println(map.put(103, "Me")); // map returns null when we put into map
        System.out.println(map.put(101, "Bheem")); // map returns old value when we update the existing value

        Set<Integer> keySet = map.keySet(); // returns all the keys in a set
        System.out.println(keySet);

        Collection<String> valuesCollection = map.values(); // returns all the values in a random collection
        System.out.println(valuesCollection);

        Set<Map.Entry<Integer, String>> entry = map.entrySet(); // return all the entries
        System.out.println(entry);

        System.out.println(map.getOrDefault(105, "Unknown")); // used to avoid null value
        System.out.println(map.putIfAbsent(102, "You")); // if key doesn't exist add it otherwise don't update the value
        System.out.println(map);

        System.out.println(map.remove(101, "Bheem")); // it only removes if it matches the key and value in the map ds
        map.replace(102, "I"); // it only updates

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> en : entries){
            Integer key = en.getKey();
            String values = en.getValue();
            System.out.println(key + ", " + values);
        }

        Map<Integer, String> m2 = Map.of(1, "I", 2, "Me"); // Immutable map

        // Tree map
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(100, "Aditya");
        tm.put(101, "Rohan");
        tm.put(102, "Tuntun");

        System.out.println(tm.firstEntry());
        System.out.println(tm.lastEntry());
    }
}
