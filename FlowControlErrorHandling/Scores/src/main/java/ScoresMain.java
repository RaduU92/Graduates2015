/**
 * Created by rursu on 7/22/2015.
 */
public class ScoresMain {
        public static void main(String args[]) {
        Scores v = new Scores();
        v.scores = new int[]{1,1,4};
        if(v.scoresIncreasing(v.scores)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
