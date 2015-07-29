import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rursu on 7/28/2015.
 */
public class PrimeNumbers extends Thread {
    public List<Integer> numbers;
    public int startIndex;
    public int endIndex;
    public List<Integer> prime;

    public static final Lock lock = new ReentrantLock();

    public PrimeNumbers(List<Integer> numbers, int startIndex, int endIndex, List<Integer> prime) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.prime = prime;
    }

    public boolean isPrime(int number) {
        boolean prim = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                prim = false;
            }
        }
        if ((number == 0) || (number == 1)) {
            prim = false;
        }
        return prim;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            if (isPrime(numbers.get(i))) {
                lock.lock();
                prime.add(numbers.get(i));
                lock.unlock();
            }
        }
    }
}
