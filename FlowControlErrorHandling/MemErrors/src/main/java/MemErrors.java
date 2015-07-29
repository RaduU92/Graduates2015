/**
 * Created by rursu on 7/22/2015.
 */
public class MemErrors {
    public static void main(String args[]) {
        Errs e = new Errs();

        try{
            e.outOfMemErr();
        } catch (OutOfMemoryError outOfMemoryError) {
            System.out.println("Out of memory ERROR!");
        }

        try{
            e.stackOverflowErr();
        } catch (StackOverflowError stackOverflowError) {
            System.out.println("Stack Overflow ERROR!");
        }
        System.out.println("Continuare program");
    }
}
