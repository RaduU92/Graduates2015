package jdbc.bon;

import jdbc.client.Client;

/**
 * Created by rursu on 8/3/2015.
 */
public class Bon {
    private int codBon;
    private Client client;
    private String data;

    public int getCodBon() {
        return codBon;
    }

    public void setCodBon(int codBon) {
        this.codBon = codBon;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
