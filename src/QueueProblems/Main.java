package QueueProblems;

public class Main {
    public static void main(String[] args) {
        QueueImplementation q = new QueueImplementation(5);
        CircularQueueImplementation cq = new CircularQueueImplementation(5);

        try{
            q.push(5);
            q.push(55);
            q.push(9);
            q.push(3);
            q.push(6);
//            q.push(9); // giving overflow error
            q.print();

            q.pop();

            q.print();
//            q.push(8); // also gives error as this queue is not circular

//            cq.print();
            cq.push(1);
            cq.push(2);
            cq.push(3);
            cq.push(4);
            cq.push(5);

            cq.print();
//            cq.push(5); // gives overflow
            cq.pop();
            cq.print();

            cq.push(10);
            cq.print();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
