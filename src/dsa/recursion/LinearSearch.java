package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 5, 6, 2, 3, 9));
        System.out.println(linear_search(list, list.size()-1, 20));
    }

    public static boolean linear_search(List<Integer> arr,int index, int key){
        if(index == -1) return false;

        if(arr.get(index) == key)
            return true;
        return linear_search(arr, index-1, key);
    }
}
