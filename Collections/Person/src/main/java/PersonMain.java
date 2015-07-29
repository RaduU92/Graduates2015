import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by rursu on 7/24/2015.
 */
public class PersonMain {
    public static void printPersonFromHashMap(HashMap<String, Person> persons, String pers) {
        Person p;
        p = persons.get(pers);
        System.out.println(p.name + " " + p.birthYear);
    }

    public static void printContainKey(HashMap<String, Person> persons, String pers) {
        System.out.println(persons.containsKey(pers));
    }

    public static void removePersonFromHashMap(HashMap<String, Person> persons, String pers) {
        persons.remove(pers);
        printContainKey(persons, pers);
    }

    public static void printHashMapContent(HashMap<String, Person> persons) {
        Iterator i = persons.keySet().iterator();
        while (i.hasNext()) {
            String p = i.next().toString();
            //printPersonFromHashMap(persons, p);
            System.out.println(persons.get(p));
        }
    }

    public static void printHashMapContent2(HashMap<String, Person> persons) {
        Iterator i = persons.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry p = (Map.Entry) i.next();
            //printPersonFromHashMap(persons, (String) p.getKey());
            System.out.println(persons.get(p.getKey()).toString());
        }
    }

    public static void printHashMapContentIt(HashMap<String, Person> persons) {
        Iterator i = persons.values().iterator();
        while (i.hasNext()) {
            String p = i.next().toString();
            System.out.println(p);
        }
    }

    public static void main(String args[]) {
        Person p1 = new Person("Johan", 1947);
        Person p2 = new Person("John", 1920);
        Person p3 = new Person("Johnny", 1970);
        Person p4 = new Person("Jonathan", 1965);

        HashMap<String, Person> persons = new HashMap();
        persons.put(p1.name, p1);
        persons.put(p2.name, p2);
        persons.put(p3.name, p3);
        persons.put(p4.name, p4);

        printPersonFromHashMap(persons, p2.name);

        printContainKey(persons, p2.name);
        printContainKey(persons, "Gigel");

        removePersonFromHashMap(persons, p2.name);

        System.out.println("Continutul hash-map-ul:");
        printHashMapContent(persons);

        System.out.println("\nInca o afisare a continutului hash-map-ului:");
        printHashMapContent2(persons);

        System.out.println("\nO noua afisare a continutului hash-map-ului:");
        printHashMapContentIt(persons);
    }
}
