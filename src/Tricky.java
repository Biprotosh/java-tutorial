public class Tricky {
    public static void main(String[] args) {
        int x = 0;
        if(x == 5){
            System.out.println("Inside if");
        }

        int i = 1;
        while (i++ <= 10)
            System.out.println(i);

        int y;
//        System.out.println(y); // gives error
    }

}
