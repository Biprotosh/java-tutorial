package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        inputList.add(3);
        inputList.add(1);
        inputList.add(2);

        fun(inputList,  inputList.size(), 0, output );
    }

    public static void fun(List<Integer> arr, int n,int index, List<Integer> l){
        if(index >= n){
            System.out.println(l);
            return;
        }

        l.add(arr.get(index));
        fun(arr, n, index+1, l);
        l.remove(arr.get(index));
        fun(arr, n, index+1, l);
    }
}
