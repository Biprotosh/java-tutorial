package dsa.recursion;

import java.util.*;

public class ReverseAnArray {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println(arr);
        rev(arr, 0, arr.size()-1);
        System.out.println(arr);
    }

    public static void rev(List<Integer> arr, int s, int e){
        if(s>=e) return;
        swap(arr, s, e);
        rev(arr, s+1, e-1);
    }

    public static void revOptimize(List<Integer> arr, int i, int n){
        if(i >= n/2) return;
        swap(arr, i, n-i-1);
        revOptimize(arr, i+1, n);
    }

    // Utility function
    public static void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
