package jdbc.dvd;

/**
 * Created by rursu on 8/3/2015.
 */
public class DVD {
    private int codDVD;
    private String titlu;
    private String descriere;
    private int durata;
    private int numarExemplare;
    private int tarifZilnic;

    public int getCodDVD() {
        return codDVD;
    }

    public void setCodDVD(int codDVD) {
        this.codDVD = codDVD;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getNumarExemplare() {
        return numarExemplare;
    }

    public void setNumarExemplare(int numarExemplare) {
        this.numarExemplare = numarExemplare;
    }

    public int getTarifZilnic() {
        return tarifZilnic;
    }

    public void setTarifZilnic(int tarifZilnic) {
        this.tarifZilnic = tarifZilnic;
    }
}
