import java.io.*;

/**
 * Created by rursu on 7/27/2015.
 */
public class CountChar {
    //  Citeste continutul fisierului caracter cu caracter si compara fiecare caracter cu cel primit ca parametru in functie
    public static int countChar(String fileName, int ch) {
        int nr = 0;
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            int c;
            while ((c = in.read()) != -1) {
                if (c == ch) {
                    nr++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit!");
        } catch (IOException e) {
            System.out.println("Eroare la accesarea fisierului!");
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return nr;
    }

    public static void main(String args[]) {
        String fileName = ".\\CountChar\\src\\main\\resources\\in.txt";
        int ch;
        System.out.println("Introduceti caracterul cautat:");
        try {
            ch = (char) System.in.read();
            System.out.println("Caracterul \"" + (char) ch + "\" apare de " + countChar(fileName, ch) + " ori.");
        } catch (IOException e) {
            System.out.println("Eroare!");
        }
    }
}
