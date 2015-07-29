/**
 * Created by rursu on 7/22/2015.
 */
public class MainClass {
    public static void main(String args[]) {
        Monkeys a = new Monkeys(true);
        Monkeys b = new Monkeys(false);

        if(a.monkeyTrouble(a,b)) {
            System.out.println("We are in TROUBLE!!!");
        } else {
            System.out.println("We are not in trouble!");
        }
    }
}
