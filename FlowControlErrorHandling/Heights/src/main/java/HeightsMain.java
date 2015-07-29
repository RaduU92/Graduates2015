/**
 * Created by rursu on 7/22/2015.
 */
public class HeightsMain {
    public static void main(String args[]) {
        Heights h = new Heights();
        h.heights = new int[]{5,3,6,7,2};
        System.out.println(h.sumHeights(h.heights,2,4));
        System.out.println(h.sumHeights(h.heights,0,1));
        System.out.println(h.sumHeights(h.heights,0,4));
    }
}
