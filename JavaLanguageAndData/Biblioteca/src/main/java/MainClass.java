import java.util.Scanner;

/**
 * Created by rursu on 7/20/2015.
 */
public class MainClass {
    public static void main(String args[]) {
        Test t = new Test();
        Carte c = new Carte("Ion","Polirom","Liviu Rebreanu",321);
        t.afisare(c);

        if(c.numarPagini == 0)
            System.out.println("Eroare! Cartea introdusa are 0 pagini!");

        System.out.println("Titlul:");
        Scanner s = new Scanner(System.in);
        String title = s.nextLine();

        System.out.println("Editura:");
        String editura = s.nextLine();

        System.out.println("Autorul:");
        String auth= s.nextLine();

        System.out.println("Numarul de pagini:");
        int nrPag = s.nextInt();

        Carte c2 = new Carte(title,editura,auth,nrPag);
        t.afisare(c2);

        if(c2.numarPagini == 0)
            System.out.println("Eroare! Cartea introdusa are 0 pagini!");

        Verificari v1 = new Verificari(c,c2);
        System.out.println(v1.dublura());
        System.out.println("Cartea mai mare este: " + v1.carteMaiMare().afisareC());
    }
}
