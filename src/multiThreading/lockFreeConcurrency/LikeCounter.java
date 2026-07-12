package multiThreading.lockFreeConcurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class LikeCounter {
    public static void main(String[] args) {
        LikeCounterClass lc = new LikeCounterClass();

        Thread t1 = new Thread(lc::like);
        Thread t2 = new Thread(lc::like);
        Thread t3 = new Thread(lc::like);
        Thread t4 = new Thread(lc::like);
        Thread t5 = new Thread(lc::like);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try{
            Thread.sleep(3000);
        }catch (Exception e){}

        System.out.println("Total likes: " + lc.totalCount.get());
    }
}

class LikeCounterClass{
//    AtomicReference<Integer> totalCount = new AtomicReference<>(0);
    AtomicInteger totalCount = new AtomicInteger(0);
    Integer currentCount;
    Integer finalCount;

    public void like() {

//        totalCount.set(totalCount.get() + 1); // it will give race condition, to avoid we are using below written logic

        // using AtomicReference
//        while (true){
//
//            // 1. We capture the latest value of totalCount
//            currentCount = totalCount.get();
//
//            // 2. Increment likeCounter by 1
//            finalCount = currentCount + 1;
//
//            // 3. compare and set with currentCount with finalCount
//            if(totalCount.compareAndSet(currentCount, finalCount))
//                return;
//
//            // 4. If a thread reaches here, then other thread must have updated the value, so we do re-try
//            System.out.println("Conflict detected. Re-trying...");
//        }

        // using AtomicInteger
        totalCount.incrementAndGet(); // internally uses the re-try logic we have written above
    }
}