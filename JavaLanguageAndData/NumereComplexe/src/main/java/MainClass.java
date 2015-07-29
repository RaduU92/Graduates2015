/**
 * Created by rursu on 7/20/2015.
 */
public class MainClass {
    public static void main(String args[]) {
        Operatii s = new Operatii();

        s.n1.re = 2;
        s.n1.im = 3;

        s.n2.re = 5;
        s.n2.re = 7;

        NumarComplex sum;
        NumarComplex prod;

        sum = s.adunare(s.n1,s.n2);
        prod = s.inmultire(s.n1,s.n2);

        System.out.println(s.n1.afisareNC() + " + " + s.n2.afisareNC() + " = " + sum.afisareNC());
        System.out.println(s.n1.afisareNC() + " * " + s.n2.afisareNC() + " = " + prod.afisareNC());
    }
}
