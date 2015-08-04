package jdbc.dvd_categorie;

import jdbc.categorie.Categorie;
import jdbc.dvd.DVD;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rursu on 8/4/2015.
 */
public class DVDCategorieMapper implements RowMapper<DVDCategorie> {
    public DVDCategorie mapRow(ResultSet rs, int rowNum) throws SQLException {
        DVDCategorie dvdCategorie = new DVDCategorie();
        DVD dvd = new DVD();
        Categorie categorie = new Categorie();
        dvdCategorie.setId(rs.getInt("D.ID"));

        dvd.setCodDVD(rs.getInt("F.ID"));
        dvd.setTitlu(rs.getString("F.TITLU"));
        dvd.setDescriere(rs.getString("F.DESCRIERE"));
        dvd.setDurata(rs.getInt("F.DURATA"));
        dvd.setNumarExemplare(rs.getInt("F.NUMAR_EXEMPLARE"));
        dvd.setTarifZilnic(rs.getInt("F.TARIF_ZILNIC"));

        categorie.setCodCategorie(rs.getInt("C.ID"));
        categorie.setDenumireCategorie(rs.getString("C.DENUMIRE"));

        dvdCategorie.setDVD(dvd);
        dvdCategorie.setCodCategorie(categorie);
        return dvdCategorie;
    }
}
