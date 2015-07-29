import java.util.ArrayList;
import java.util.List;

/**
 * Created by rursu on 7/22/2015.
 */
public class Calculator {
    public static int add(int a, int b) throws OverflowException, UnderflowException {
        long sum = (long)a + b;
        if(sum > Integer.MAX_VALUE) {
            throw new OverflowException();
        }

        if(sum < Integer.MIN_VALUE) {
            throw new UnderflowException();
        }

        return (int)sum;
    }

    public static int divide(int a, int b) {
        return a/b;
    }

    public static int average(List<Integer> numbers) throws OverflowException, UnderflowException {
        long avg = 0;
        for(int nr : numbers) {
            avg += nr;
        }
        avg = avg/numbers.size();

        if(avg > Integer.MAX_VALUE) {
            throw new OverflowException();
        }

        if(avg < Integer.MIN_VALUE) {
            throw new UnderflowException();
        }

        return (int)avg;
    }

    public static void main(String args[]) {
        int a = Integer.MIN_VALUE;
        int b = -10;

        try{
            System.out.println(a + " + " + b + " = " + add(a,b));
        } catch (OverflowException e) {
            System.out.println("Sum Overflow Exception");
        } catch (UnderflowException e) {
            System.out.println("Sum Underflow Exception");
        }

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(Integer.MAX_VALUE);
        numbers.add(Integer.MAX_VALUE);
        numbers.add(0);

        try{
            System.out.println(average(numbers));
        } catch (OverflowException e) {
            System.out.println("Average Overflow Exception");
        } catch (UnderflowException e) {
            System.out.println("Average Underflow Exception");
        }

    }
}
