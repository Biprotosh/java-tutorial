package multiThreading.lockFreeConcurrency;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTut {
    public static void main(String[] args) {
        SeatBooking sb = new SeatBooking();

        Thread t1 = new Thread(() -> {
            System.out.println("T1 says: " + sb.bookSeat("TunTun"));
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2 says: " + sb.bookSeat("Bheem"));
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb.seat);
    }
}

class SeatBooking{
//    String seat = "EMPTY";

    AtomicReference<String> seat = new AtomicReference<>("EMPTY");

    public boolean bookSeat(String name){

//        if(seat.equals("EMPTY")){
//            seat = name;
//            return true;
//        }
//
//        return false;

        // compare and set operation. Heart of lock free concurrency
        String currentValue = seat.get();

        if(!currentValue.equals("EMPTY"))
            return false;

        return seat.compareAndSet("EMPTY", name);
    }
}

/*
    if(seat.equals("EMPTY")){
            seat = name;
            return true;
     }

     this non-atomic code is converted to atomic code using: return seat.compareAndSet("EMPTY", name);

     It solved the race condition using lock free concurrency
 */