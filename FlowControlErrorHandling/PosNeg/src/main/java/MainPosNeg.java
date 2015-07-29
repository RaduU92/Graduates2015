/**
 * Created by rursu on 7/22/2015.
 */
public class MainPosNeg {
    public static boolean posNeg(int a, int b, boolean negative) {
        if(negative) {
            if(a < 0 && b < 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if((a < 0 && b > 0) || (a > 0 && b < 0)) {
                return true;
            } else {
                return false;
            }
        }
    }
    public static void main(String args[]) {
        boolean negative = false;
        int a = 7;
        int b = -1;
        if(posNeg(a,b,negative)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
