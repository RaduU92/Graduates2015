import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rursu on 7/28/2015.
 */
public class Main {
    public static void main(String args[]) {
//      Lista de numere
        List<Integer> numbers = new ArrayList<Integer>();

//      Lista cu numere prime
        List<Integer> prime = new ArrayList<Integer>();

        Random rand = new Random();

//      Numarul de elemente din lista initiala
        int n = 12;

//      Popularea listei initiale
        for (int i = 0; i < n; i++) {
            numbers.add(rand.nextInt(100));
//            numbers.add(i);
        }

        System.out.println("Lista initiala: \n" + numbers);

//      Numarul de thread-uri
        int nrThreads = 2;

//      Lista cu thread-uri + initializarea ei
        List<PrimeNumbers> pNr = new ArrayList<PrimeNumbers>();
        for (int i = 0; i < nrThreads; i++) {
            pNr.add(new PrimeNumbers(numbers, i * numbers.size() / nrThreads, (i + 1) * numbers.size() / nrThreads, prime));
        }

        long startTime = System.currentTimeMillis();
        long startTime1 = System.nanoTime();

        for (int i = 0; i < nrThreads; i++) {
            pNr.get(i).start();
        }

        for (int i = 0; i < nrThreads; i++) {
            try {
                pNr.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long estimatedTime = System.currentTimeMillis() - startTime;
        long estimatedTime1 = System.nanoTime() - startTime1;

        System.out.println("Lista cu numerele prime:\n" + prime);
        System.out.println("Timpul de executie pentru " + nrThreads + " thread-uri este: " + estimatedTime + "ms.");
        System.out.println("Timpul de executie pentru " + nrThreads + " thread-uri este: " + estimatedTime1 + "ns.");
    }
}
