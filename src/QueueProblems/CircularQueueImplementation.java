package QueueProblems;

public class CircularQueueImplementation {
    int[] arr;
    int front, rear;
    int size;

    CircularQueueImplementation(int size){
        arr = new int[size];
        this.size = size;
        front = rear = -1;
    }

    void push(int data) throws OverflowException{
        if(isFull())
            throw new OverflowException("Overflow");
        else if (front == -1) {
            front = 0;
        }
//        else if(rear == size-1 && front != 0)
//            rear = 0;
//        else rear++;
        rear = (rear + 1) % size;

        arr[rear] = data;
        System.out.println(data + " is inserted");
    }

    int pop() throws UnderflowException{
        if(front == -1)
            throw new UnderflowException("Underflow");
        int data = arr[front];

        if(front == rear)
            front = rear = -1;
        else front = (front + 1 ) % size;

        System.out.println(data + " is poped");
        return data;
    }

    boolean isFull(){
//        return front == 0 && rear == size-1 || rear+1 == front;
        return (rear + 1) % size == front;
    }


    void print(){
        if(front < rear){
            for(int i = front; i<=rear; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }else if(front != -1){
            for(int i = front; i<size; i++)
                System.out.print(arr[i] + " ");

            for(int i = 0; i<=rear; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}



















