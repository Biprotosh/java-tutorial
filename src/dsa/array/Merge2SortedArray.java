package dsa.array;

import java.util.*;

public class Merge2SortedArray {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(List.of(1, 2, 3, 5));
        List<Integer> l2 = new ArrayList<>(List.of(3, 5, 8, 9, 10, 15));
        List<Integer> res = new ArrayList<>();

        merge(l1, l2, res);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println("Merged array: " + res);
    }

    public static void merge(List<Integer> l1, List<Integer> l2, List<Integer> res){
        int index1 = 0;
        int sizeOfL1 = l1.size();

        int index2 = 0;
        int sizeOfL2 = l2.size();


        while (index1 < sizeOfL1 && index2 < sizeOfL2){
            if(l1.get(index1) <= l2.get(index2)){
                res.add(l1.get(index1));
                index1++;
            }
            else {
                res.add(l2.get(index2));
                index2++;
            }
        }

        while (index1 < sizeOfL1)
            res.add(l1.get(index1++));

        while (index2 < sizeOfL2)
            res.add(l2.get(index2++));
    }
}
