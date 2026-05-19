package QueueProblems;

class OverflowException extends Exception{
    public OverflowException(String s){
        super(s);
    }
}

class UnderflowException extends Exception{
    public UnderflowException(String s){
        super(s);
    }
}

public class QueueImplementation {
    int[] arr;
    int front;
    int rear;
    int size;

    QueueImplementation(int size){
        arr = new int[size];
        front = rear = 0;
        this.size = size;
    }

    void push(int data) throws OverflowException{
        if(rear == size)
            throw new OverflowException("Overflow");

        arr[rear++] = data;
        System.out.println(data + " is entered");
    }

    int pop() throws UnderflowException{
        if(isEmpty())
            throw new UnderflowException("Underflow");

        int data = arr[front++];
        System.out.println(data + " is poped");

        if(isEmpty())
            front = rear = 0;

        return data;
    }

    int getFront(){
        if(isEmpty())
            return -1;

        return arr[front];
    }

    int getRear(){
        if(isEmpty())
            return -1;

        return arr[rear];
    }

    boolean isEmpty(){
        return front == rear;
    }

    void print(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }

        for (int i = front; i < rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
