package Recurssion;

public class PowerOfTwoNumber {
    static double cal(int base, int exponent){
        if(exponent == 0)
            return 1;
        else if(exponent < 0)
            return 1 / cal(base, -exponent);

        return base*cal(base, exponent-1);
    }
}
