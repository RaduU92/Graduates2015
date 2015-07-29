/**
 * Created by rursu on 7/20/2015.
 */
public class Verificari {
    public Carte c1;
    public Carte c2;

    public Verificari(Carte c1, Carte c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public String dublura() {
        int ok = 1;

        if (c1.titlu == c2.titlu) {
            ok = 0;
        }
        if (c1.autor == c2.autor) {
            ok = 0;
        }
        if (c1.editura == c2.editura) {
            ok = 0;
        }
        if (c1.numarPagini == c2.numarPagini) {
            ok = 0;
        }

        if(ok == 1) {
            return "Cartile sunt diferite!";
        }
        else {
            return "Cartile sunt identice!";
        }
    }

    public Carte carteMaiMare() {
        if(this.c1.numarPagini>this.c2.numarPagini)
            return c1;
        else
            return c2;
    }
}
