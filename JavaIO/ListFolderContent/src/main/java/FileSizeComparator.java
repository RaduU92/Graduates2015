import java.io.File;
import java.util.Comparator;

/**
 * Created by rursu on 7/27/2015.
 */
public class FileSizeComparator implements Comparator<File> {
    public int compare(File f1, File f2) {
        if (f1.length() < f2.length()) {
            return -1;
        } else if (f1.length() > f2.length()) {
            return 1;
        } else {
            return 0;
        }
    }
}
