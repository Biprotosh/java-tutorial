package dsa.recursion;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        System.out.println(binary_search(list, 5, 0, list.size()-1));
    }

    public static boolean binary_search(List<Integer> arr, int key, int s, int e){
        if(s>=e) return false;

//        int mid = (s+e)/2;
        int mid = s + (e-s)/2;
        int element = arr.get(mid);

        if(element == key)
            return true;
        else if(element > mid)
            s = mid + 1;
        else e = mid - 1;

        return binary_search(arr, key, s, e);
    }
}
