package dsa.recursion;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 8, 7, 1};

        for(int i: arr)
            System.out.print(i + " ");

        System.out.println();

        sort(arr, 0, arr.length-1);
        for(int i: arr)
            System.out.print(i + " ");
    }

    public static void sort(int[] arr, int s, int e){
        if(s == e)
            return;

        int mid = s + (e-s)/2;

        sort(arr, s, mid); // left part
        sort(arr, mid+1, e); // right part

        merge2SortedArray(arr, s, mid, e);
    }

    public static void merge2SortedArray(int[] arr, int s, int mid, int e){
        int[] temp = new int[e-s+1];
        int left = s;
        int right = mid+1;
        int index = 0;

        while (left <= mid && right <= e){
            if(arr[left] <= arr[right])
                temp[index++] = arr[left++];
            else temp[index++] = arr[right++];
        }

        while(left <= mid){
            temp[index++] = arr[left++];
        }

        while (right <= e){
            temp[index++] = arr[right++];
        }

        index = 0;
        for(int i = s; i<=e; i++)
            arr[i] = temp[index++];
    }
}
