package multiThreading.executerCollectionFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExecutorTut {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        try(ForkJoinPool pool = new ForkJoinPool()){
            SumTask task = new SumTask(arr, 0, arr.length-1);
            int res = pool.invoke(task);
            System.out.println("Result: " + res );
        }
    }
}

class SumTask extends RecursiveTask<Integer>{

    private int[] arr;
    private int start;
    private int end;

    public SumTask(int[] arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        // Base conditon
        if(end - start <= 2){
            int sum = 0;
            for(int i = start; i <= end; i++)
                sum += arr[i];
            return sum;
        }

        // main logic --> fork
        int mid = start + (end - start) / 2;
        SumTask leftTask = new SumTask(arr, start, mid);
        SumTask rightTask = new SumTask(arr, mid+1, end);

        leftTask.fork(); // place it to the work stealing queue
        int sum2 = rightTask.compute(); // compute the right task

        int sum1 = leftTask.join(); // pause the current thread

        // join
        return sum1 + sum2;
    }
}

/*
    Always use fork join pool class to create a pool recommended in java docs rather than using a pool from Executors
 */