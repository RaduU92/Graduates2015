import java.io.*;
import java.util.*;

/**
 * Created by rursu on 7/27/2015.
 */
public class JavaIO {
    public static void readFromFile(String fileName, List<String> lines) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException x) {
            x.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reversePrintList(List<String> lines) {
        for (int i = lines.size() - 1; i >= 0; i--) {
            System.out.println(lines.get(i));
        }
    }

    public static void main(String args[]) {
        List<String> lines = new ArrayList<String>();
        String fileName = ".\\FileListContent\\src\\main\\resources\\in.txt";
        readFromFile(fileName, lines);
        reversePrintList(lines);
    }
}
