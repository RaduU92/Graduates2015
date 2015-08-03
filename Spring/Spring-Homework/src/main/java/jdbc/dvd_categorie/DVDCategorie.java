package jdbc.dvd_categorie;

import jdbc.categorie.Categorie;
import jdbc.dvd.DVD;

/**
 * Created by rursu on 8/3/2015.
 */
public class DVDCategorie {
    private int id;
    private DVD dvd;
    private Categorie categorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DVD getDVD() {
        return dvd;
    }

    public void setDVD(DVD dvd) {
        this.dvd = dvd;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCodCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
