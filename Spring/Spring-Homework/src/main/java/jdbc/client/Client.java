package jdbc.client;

import jdbc.oras.Oras;

/**
 * Created by rursu on 8/3/2015.
 */
public class Client {
    private int codClient;
    private String nume;
    private String adresa;
    private Oras oras;

    public int getCodClient() {
        return codClient;
    }

    public void setCodClient(int codClient) {
        this.codClient = codClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Oras getOras() {
        return oras;
    }

    public void setCodOras(Oras oras) {
        this.oras = oras;
    }
}
