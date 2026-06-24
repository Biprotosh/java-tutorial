package collectionFramework;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Simple queue
        queue.offer(1);
        queue.offer(2); // it returns false if value is not added
        queue.add(3); // it throws exception if any problem occurs

        System.out.println(queue.peek()); // peek() returns null, if element is not there
        System.out.println(queue.element()); // element() throws exception

        queue.poll(); // return null
        queue.remove(); // throws exception

        // Priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default it uses min-heap
        System.out.println("------ Using Min-heap ------");
        pq.offer(10);
        pq.offer(20);
        pq.offer(30);
        pq.offer(40);
        pq.offer(50);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b) -> b-a); // now it is using max-heap
        System.out.println("------ Using Max-heap ------");
        pq2.offer(10);
        pq2.offer(20);
        pq2.offer(30);
        pq2.offer(40);
        pq2.offer(50);

        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
    }
}
