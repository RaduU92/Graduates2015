/**
 * Created by rursu on 7/22/2015.
 */
public class MainClass {
    public static void main(String args[]) {
        Parrot p = new Parrot(true);
        if(p.parrotTrouble(p.talking,10)) {
            System.out.println("Trouble!");
        } else {
            System.out.println("OK!");
        }
    }
}
