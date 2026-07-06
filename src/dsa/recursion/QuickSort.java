package dsa.recursion;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 8, 7, 1};

        for(int i: arr)
            System.out.print(i + " ");

        System.out.println();

        sort(arr, 0, arr.length-1);
        for(int i: arr)
            System.out.print(i + " ");
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr, int s, int e){
        if(s >= e)
            return;

        int pivotIndex = partition(arr, s, e);
        sort(arr, s, pivotIndex-1); // left part
        sort(arr, pivotIndex+1, e); // right part
    }

    public static int partition(int[] arr, int s, int e){
        // 1st approach

        int pivotElement = arr[e];
        int pos = s;

        for (int i = s; i<=e; i++){
            if(arr[i] <= pivotElement){
                swap(arr, i, pos);
                pos++;
            }
        }

        return pos-1;

        // 2nd approach

//        int pivotElement = arr[s];
//        int cnt = 0;
//        for(int i = s+1; i<=e; i++)
//            if(arr[i] <= pivotElement)
//                cnt++;
//
//        int pivotIndex = s + cnt;
//        swap(arr, s, pivotIndex);
//
//        while (s < pivotIndex && e > pivotIndex){
//            while (arr[s] <= pivotElement)
//                s++;
//
//            while (arr[e] > pivotElement)
//                e--;
//
//            if(s < pivotIndex && e > pivotIndex)
//                swap(arr, s, e);
//        }
//
//        return pivotIndex;
    }
}
