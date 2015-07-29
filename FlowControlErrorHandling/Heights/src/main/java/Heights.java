/**
 * Created by rursu on 7/22/2015.
 */
public class Heights {
    public int[] heights;

    public int sumHeights(int[] heights, int stat, int end) {
        int sum = 0;
        for(int i = stat; i < end; i++) {
            sum = sum + Math.abs(heights[i]-heights[i+1]) ;
        }
        return sum;
    }
}
