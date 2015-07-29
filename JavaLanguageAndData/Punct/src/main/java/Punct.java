/**
 * Created by rursu on 7/20/2015.
 */
public class Punct {
    public float x;
    public float y;

    public Punct (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void afisare() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }
}
