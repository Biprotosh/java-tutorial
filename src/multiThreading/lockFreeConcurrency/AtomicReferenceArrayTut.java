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

            if(!currVal.equals("EMPTY"))
                continue;

            if(arr.compareAndSet(i, "EMPTY", name)){
                System.out.println(name + " got the " + i + "th seat booked by: " + Thread.currentThread().getName());
                return;
            }
        }
        System.out.println(name + " could not find an available seat.");
    }
}
