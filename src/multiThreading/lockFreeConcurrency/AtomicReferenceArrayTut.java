package multiThreading.lockFreeConcurrency;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayTut {
    public static void main(String[] args) {

        MultipleSeatBooking seat = new MultipleSeatBooking();

        Thread t1 = Thread.startVirtualThread(() -> {
            seat.bookSeat("Bheem");
        });

        Thread t2 = Thread.startVirtualThread(() -> {
            seat.bookSeat("Jaggu");
        });

        Thread t3 = Thread.startVirtualThread(() -> {
            seat.bookSeat("Raju");
        });

        Thread t4 = Thread.startVirtualThread(() -> {
            seat.bookSeat("Kalia");
        });

        Thread t5 = Thread.startVirtualThread(() -> {
            seat.bookSeat("Dholu");
        });

        Thread t6 = Thread.startVirtualThread(() -> {
            seat.bookSeat("Bholu");
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MultipleSeatBooking{
    private AtomicReferenceArray<String> arr = new AtomicReferenceArray<>(5);

    public MultipleSeatBooking(){
        for(int i = 0; i<5; i++){
            arr.set(i, "EMPTY");
        }
    }

    public void bookSeat(String name){
        for(int i = 0; i<5; i++){
            String currVal = arr.get(i);

            if(!"EMPTY".equals(currVal)) // even if currVal is null, it just returns false. because equals() is called using a string literal
                continue;

            if(arr.compareAndSet(i, "EMPTY", name)){
                System.out.println(name + " got the " + i + "th seat booked by: " + Thread.currentThread().getName());
                return;
            }
        }
        System.out.println(name + " could not find an available seat.");
    }
}

/*
    TOCTOU = Time Of Check vs Time Of Use.
    It's the gap between when you CHECK a condition and when you ACT on it. In that gap — another thread can change the world.
    Your check becomes stale. Your action is based on a lie.
 */
