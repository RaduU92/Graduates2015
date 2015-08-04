package jdbc.dvd;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rursu on 8/4/2015.
 */
public class DVDMapper implements RowMapper<DVD> {
    public DVD mapRow(ResultSet rs, int rowNum) throws SQLException {
        DVD dvd = new DVD();
        dvd.setCodDVD(rs.getInt("ID"));
        dvd.setTitlu(rs.getString("TITLU"));
        dvd.setDescriere(rs.getString("DESCRIERE"));
        dvd.setDurata(rs.getInt("DURATA"));
        dvd.setNumarExemplare(rs.getInt("NUMAR_EXEMPLARE"));
        dvd.setTarifZilnic(rs.getInt("TARIF_ZILNIC"));
        return dvd;
    }
}
