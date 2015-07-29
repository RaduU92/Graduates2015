/**
 * Created by rursu on 7/22/2015.
 */
public class FinallyExecution {
    public static int test() {
        try{
            System.out.println("Try");
            return 1;
        } catch (Exception e) {
            System.out.println("Catch");
        } finally {
            System.out.println("Finally");
        }
        return 0;
    }

    public static void main(String args[]) {
        System.out.println(test());
    }
}
