import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by rursu on 7/28/2015.
 */
public class WordPercentage extends Thread {
    //public Map<String, Integer> words;
    public ConcurrentMap<String, Integer> words;
    public List<String> lines;
    public int startIndex;
    public int endIndex;


    //public WordPercentage(List<String> lines, MapMap<String, Integer> words, int startIndex, int endIndex) {
    public WordPercentage(List<String> lines, ConcurrentMap<String, Integer> words, int startIndex, int endIndex) {
        this.lines = lines;
        this.words = words;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int j = startIndex; j < endIndex; j++) {
            String line = lines.get(j);
            synchronized (this.words) {
                for (int i = 0; i < line.split(" ").length; i++) {
                    if (!words.containsKey(line.split(" ")[i])) {
                        words.put(line.split(" ")[i], 1);
                    } else {
                        words.put(line.split(" ")[i], words.get(line.split(" ")[i]) + 1);
                    }
                }
            }
        }
    }
}
