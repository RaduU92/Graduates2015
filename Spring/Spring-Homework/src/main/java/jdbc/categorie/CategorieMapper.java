package jdbc.categorie;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rursu on 03.08.2015.
 */
public class CategorieMapper implements RowMapper<Categorie> {
    public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categorie categorie = new Categorie();
        categorie.setCodCategorie(rs.getInt("ID"));
        categorie.setDenumireCategorie(rs.getString("DENUMIRE_CATEGORIE"));
        return categorie;
    }
}