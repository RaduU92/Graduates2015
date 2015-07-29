import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by rursu on 7/28/2015.
 */
public class MainWordPercentage {
    // Citire continut fisier
    public static void readFromFile(String fileName, List<String> lines) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit!");
        } catch (IOException x) {
            System.out.println("Eroare la accesarea fisierului!");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Eroare la inchiderea fisierului!");
            }
        }
    }

    // Afisare continut colectie
    public static void printHashMapContent(ConcurrentMap<String, Integer> words) {
        Iterator i = words.keySet().iterator();
        while (i.hasNext()) {
            String w = i.next().toString();
            System.out.println(w + " " + words.get(w));
        }
    }

    public static void computePercent(ConcurrentMap<String, Integer> words, String fileName) {
        int sum = 0;
        Iterator i = words.keySet().iterator();
        while (i.hasNext()) {
            String w = i.next().toString();
            sum += words.get(w);
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            Iterator j = words.keySet().iterator();
            while (j.hasNext()) {
                String w = j.next().toString();
                bw.write(w + ", " + (float)(words.get(w)*100)/sum + "%\n");
//                System.out.println(w + ": " + words.get(w) + "   " + sum + "     " + (float)(words.get(w)*100)/sum +  "%\n");
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("Eroare la scriere!");
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Eroare la inchiderea fisierului!");
            }
        }
    }

    public static void main(String args[]) {
        List<String> lines = new ArrayList<String>();
        String fileName = ".\\WordsPercentage\\src\\main\\resources\\in.txt";

        String outputFileName = ".\\WordsPercentage\\src\\main\\resources\\out.txt";

        ConcurrentMap<String, Integer> words = new ConcurrentHashMap<String, Integer>();

        readFromFile(fileName, lines);
//      createWordsList(lines, words);

//      Numarul de thread-uri
        int nrThreads = 3;

//      Lista cu thread-uri + initializarea ei
        List<WordPercentage> wP = new ArrayList<WordPercentage>();
        for (int i = 0; i < nrThreads; i++) {
            wP.add(new WordPercentage(lines, words, i * lines.size() / nrThreads, (i + 1) * lines.size() / nrThreads));
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < nrThreads; i++) {
            wP.get(i).start();
        }

        for (int i = 0; i < nrThreads; i++) {
            try {
                wP.get(i).join();
            } catch (InterruptedException e) {
                System.out.println("Eroare la sincronizare!");
            }
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime + "ns.");
//      printHashMapContent(words);
        computePercent(words, outputFileName);
    }
}
