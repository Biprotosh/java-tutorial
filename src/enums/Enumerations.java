package enums;

public class Enumerations {
    public static void main(String[] args) {
        System.out.println(PaymentStatus.SUCCESS);
        System.out.println(PaymentStatus.FAILED);
        System.out.println(PaymentStatus.PENDING);

        PaymentStatus status = PaymentStatus.SUCCESS;
        System.out.println(status.name());

        Direction d1 = Direction.WEST;
        Direction d2 = Direction.NORTH;
        System.out.println(d1.getDegree());

        d1.move();
        d2.move();

        // methods of enum
        for(Direction i: Direction.values()){
            System.out.println(i);
        }

        System.out.println(PaymentStatus.FAILED.ordinal());
    }
}

enum PaymentStatus{
    SUCCESS,
    FAILED,
    PENDING;
}

enum Direction{
    // using anonymous class
    NORTH(0){
        @Override
        public void move(){
            System.out.println("Move up (interfaces.Y+1)");
        }
    },
    EAST(90){
        @Override
        public void move(){
            System.out.println("Move right (interfaces.X+1)");
        }
    },
    SOUTH(180){
        @Override
        public void move(){
            System.out.println("Move down (interfaces.Y-1)");
        }
    },
    WEST(270){
        @Override
        public void move(){
            System.out.println("Move left (interfaces.X-1)");
        }
    };

    private int degree;

    Direction(int degree){ // java by default makes it private
        this.degree = degree;
    }

    public int getDegree(){
        return this.degree;
    }

    public abstract void move();
}