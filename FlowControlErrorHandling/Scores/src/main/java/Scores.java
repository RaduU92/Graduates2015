/**
 * Created by rursu on 7/22/2015.
 */
public class Scores {
    public int[] scores;

    public boolean scoresIncreasing(int[] scores) {
        boolean ok = true;
        for(int i = 1; i < scores.length; i++){
            if(scores[i-1] > scores[i]) {
                ok = false;
            }
        }
        return ok;
    }
}
