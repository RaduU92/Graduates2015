/**
 * Created by rursu on 7/24/2015.
 */
public class Person {
    public String name;
    public int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthYear;
    }
}
