import java.io.*;
import java.util.*;

/**
 * Created by rursu on 7/24/2015.
 */
public class TestMapList {
    // Citire din fisier si populare cu programe
    public static void readPrograms(String file, Map<String, ArrayList<TVSeries>> programs) {
        try {
            FileReader f = new FileReader(file);
            BufferedReader br = new BufferedReader(f);
            String line;
            String[] parts;
            while ((line = br.readLine()) != null) {
                parts = line.split("-");
                TVSeries tvs = new TVSeries(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5]);
                if (programs.containsKey(parts[0])) {
                    programs.get(parts[0]).add(tvs);
                } else {
                    programs.put(parts[0], new ArrayList());
                    programs.get(parts[0]).add(tvs);
                }
            }
            br.close();
            f.close();
        } catch (IOException x) {
            System.out.println("Eroare la deschiderea fisierului!");
        }
    }

    // Afisare tot continutul colectiei
    public static void printHashMapContent(Map<String, ArrayList<TVSeries>> programs) {
        Iterator i = programs.keySet().iterator();
        while (i.hasNext()) {
            String p = i.next().toString();
            //System.out.println(p + " - " + programs.get(p).TVStoString());
            System.out.println(p);// + " - " + programs.get(p).TVStoString());
            for (TVSeries t : programs.get(p)) {
                System.out.println("   " + t.TVStoString());
            }
        }
    }

    // afisare serialele difuzate pe un anume program tv
    public static void printTVSeriesForProgram(Map<String, ArrayList<TVSeries>> programs, String program) {
        if (programs.containsKey(program)) {
            System.out.println(program);
            for (TVSeries t : programs.get(program)) {
                System.out.println("   " + t.TVStoString());
            }
        } else {
            System.out.println("Programul nu exista in lista!");
        }
    }

    // Afisare detalii despre un anume serial
    public static void printHashMapSeriesContent(Map<String, ArrayList<TVSeries>> programs, String pro) {
        Iterator i = programs.keySet().iterator();
        while (i.hasNext()) {
            String p = i.next().toString();
            for (TVSeries t : programs.get(p)) {
                if (t.name.equals(pro)) {
                    System.out.println(" " + p + "  -  " + t.TVStoString());
                }
            }
        }
    }

    // afisare toate serialele de un anume tip
    public static void printHashMapTypeContent(Map<String, ArrayList<TVSeries>> programs, String tip) {
        Iterator i = programs.keySet().iterator();
        while (i.hasNext()) {
            String p = i.next().toString();
            for (TVSeries t : programs.get(p)) {
                if (t.type.equals(tip)) {
                    System.out.println(p + "  -  " + t.TVStoString());
                }
            }
        }
    }

    public static void main(String args[]) {
        HashMap<String, ArrayList<TVSeries>> programs = new HashMap<String, ArrayList<TVSeries>>();
        String file = "D:/rursu/IdeaProjects/Collections/TVSeries/src/main/resources/info.txt";

        readPrograms(file, programs);
        printHashMapContent(programs);

        System.out.println("-----");
        printTVSeriesForProgram(programs, "PRO TV");
        printTVSeriesForProgram(programs, "zklndfka");

        System.out.println("\n------");
        printHashMapSeriesContent(programs, "Mr. Bean");

        System.out.println("\n------");
        printHashMapTypeContent(programs, "Comedy");
    }
}
