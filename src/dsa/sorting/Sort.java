package dsa.sorting;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};

        System.out.print("Original Array -> ");
        printArr(arr);

//        bubbleSort(arr);
        insertionSort(arr);
        printArr(arr);
    }

    static void printArr(int[] arr){
        for(int i:arr)
            System.out.print(i + " ");
        System.out.println();
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSort(int[] arr){
        int length = arr.length;

        for(int i = 1; i<length; i++){
            int temp = arr[i];
            int j;
            for(j = i-1; j>=0; j--){
                if(arr[j] > temp)
                    swap(arr, j, j+1);
                else break;
            }

            arr[j+1] = temp;
        }
    }

    static void insertionSort(int[] arr){
        int length = arr.length;
        boolean exchange = true;

        for (int i = 1; i < length && exchange; i++) {
            int j;
            int temp = arr[i];
            exchange = false;

            for (j = i-1; j>=0; j--){
                if(arr[j] > temp){
                    arr[j+1] = arr[j];
                    exchange = true;
                }
                else break;
            }
            arr[j+1] = temp;
        }
    }
}
