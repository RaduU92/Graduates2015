package jdbc.inchiriere;

import jdbc.bon.Bon;
import jdbc.dvd.DVD;

/**
 * Created by rursu on 8/3/2015.
 */
public class Inchiriere {
    private int codInchiriere;
    private Bon bon;
    private DVD dvd;

    public int getCodInchiriere() {
        return codInchiriere;
    }

    public void setCodInchiriere(int codInchiriere) {
        this.codInchiriere = codInchiriere;
    }

    public Bon getBon() {
        return bon;
    }

    public void setCodBon(Bon bon) {
        this.bon = bon;
    }

    public DVD getDVD() {
        return dvd;
    }

    public void setDVD(DVD dvd) {
        this.dvd = dvd;
    }
}
