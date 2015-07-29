/**
 * Created by rursu on 7/20/2015.
 */
public class Carte {
    //titlu, editura, autor, numarPagini
    public String titlu;
    public String editura;
    public String autor;
    public int numarPagini;

    Carte(String title, String ed, String auth, int np) {
        this.titlu = title;
        this.editura = ed;
        this.autor = auth;
        this.numarPagini = np;
    }

    public String afisareC() {
        String s = "Autor: " + this.autor + ", \"" + this.titlu.toUpperCase() + "\", Editura: " + this.editura.toLowerCase() + ", numar pagini: " + this.numarPagini;

        return s;
    }
}
