/**
 * Created by rursu on 7/22/2015.
 */
public class Monkeys {
    public boolean smile;

    public boolean isSmile() {
        return smile;
    }

    public void setSmile(boolean smile) {
        this.smile = smile;
    }

    public Monkeys(boolean smile) {
        this.smile = smile;
    }

    public boolean monkeyTrouble(Monkeys a, Monkeys b) {
        return a.smile == b.smile;
    }
}
