public class CallByValueCallByReference {

    // There is no call by reference in java
    public static void main(String[] args) {
        int x = 4, y = 5;

        Add a1 = new Add(10, 20);

        System.out.println("Call by value");
        System.out.println(x + " " + y);
        add(x, y);
        System.out.println(x + " " + y);
        System.out.println();

        System.out.println("Call by reference");
        System.out.println(a1.x + " " + a1.y);
        add(a1);
        System.out.println(a1.x + " " + a1.y);
    }

    static void add(int x, int y){
        x += 10;
        y += 10;
    }

    static void add(Add obj){
        obj.x += 10;
        obj.y += 10;
    }
}

class Add{
    int x, y;
    Add(int x, int y){
        this.x = x;
        this.y = y;
    }
}
