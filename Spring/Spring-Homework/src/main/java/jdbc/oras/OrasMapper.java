package jdbc.oras;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rursu on 8/4/2015.
 */
public class OrasMapper implements RowMapper<Oras> {
    public Oras mapRow(ResultSet rs, int rowNum) throws SQLException {
        Oras oras = new Oras();

        oras.setCodOras(rs.getInt("ID"));
        oras.setNume(rs.getString("NUME"));

        return oras;
    }
}
