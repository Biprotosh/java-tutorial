package Recurssion;

public class ReverseArray {
    static void reverse(int[] arr, int i, int j){
        if(i>=j)
            return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i+1, j-1);
    }
}
