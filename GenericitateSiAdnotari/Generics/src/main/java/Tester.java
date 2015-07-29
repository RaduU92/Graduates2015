import java.util.*;

/**
 * Created by rursu on 7/23/2015.
 */
class Tester<T> {
    /* The list of bugs */
    private List<T> bugs;

    /* Constuctor where you initialize the list of bugs */
    public Tester(){
        this.bugs = new ArrayList<T>();
    }

    /* Method for adding a bug to the bug list */
    public void addBug(T newBug) {
        this.bugs.add(newBug);
    }

    /* Method for getting the last bug from the bug list */
    public T getLastBug() {
        return bugs.get(bugs.size()-1);
    }

    /* Main method for testing the class functionality */
    public static void main (String[] args){
        Tester<Integer> b = new Tester();
        b.addBug(1);
        b.addBug(2);
        b.addBug(3);
        b.addBug(4);

        System.out.println(b.getLastBug());

        Tester<Float> bb = new Tester();
        bb.addBug((float)1);
        bb.addBug((float)2);
        bb.addBug((float)3);
        bb.addBug((float)4);
        bb.addBug((float)5);

        System.out.println(bb.getLastBug());
    }
}
