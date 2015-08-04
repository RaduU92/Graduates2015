package jdbc.inchiriere;

import jdbc.bon.Bon;
import jdbc.client.Client;
import jdbc.dvd.DVD;
import jdbc.dvd_categorie.DVDCategorie;
import jdbc.oras.Oras;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rursu on 8/4/2015.
 */
public class InchiriereMapper implements RowMapper<Inchiriere> {
    public Inchiriere mapRow(ResultSet rs, int rowNum) throws SQLException {
        Inchiriere inchiriere = new Inchiriere();
        Bon bon = new Bon();
        DVD dvd = new DVD();
        Client client = new Client();
        Oras oras = new Oras();

        inchiriere.setCodInchiriere(rs.getInt("I.ID"));

        bon.setCodBon(rs.getInt("B.ID"));
        bon.setData(rs.getString("B.DATA"));
        client.setCodClient(rs.getInt("C.ID"));
        client.setAdresa(rs.getString("C.ADRESA"));
        client.setNume(rs.getString("C.NUME"));
        oras.setCodOras(rs.getInt("O.ID"));
        oras.setNume(rs.getString("O.NUME"));

        dvd.setCodDVD(rs.getInt("F.ID"));
        dvd.setTitlu(rs.getString("F.TITLU"));
        dvd.setDescriere(rs.getString("F.DESCRIERE"));
        dvd.setDurata(rs.getInt("F.DURATA"));
        dvd.setNumarExemplare(rs.getInt("F.NUMAR_EXEMPLARE"));
        dvd.setTarifZilnic(rs.getInt("F.TARIF_ZILNIC"));

        client.setCodOras(oras);
        bon.setClient(client);

        inchiriere.setDVD(dvd);
        inchiriere.setCodBon(bon);
        return inchiriere;
    }
}
