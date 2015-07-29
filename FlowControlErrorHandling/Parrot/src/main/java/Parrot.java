/**
 * Created by rursu on 7/22/2015.
 */
public class Parrot {
    public boolean talking;

    public boolean isTalking() {
        return talking;
    }

    public void setTalking(boolean talking) {
        this.talking = talking;
    }

    public Parrot(boolean talking) {
        this.talking = talking;
    }

    public boolean parrotTrouble(boolean talking, int hour) {
        if(talking && ((hour < 7) || (hour > 20))) {
            return true;
        } else {
            return false;
        }
    }
}
