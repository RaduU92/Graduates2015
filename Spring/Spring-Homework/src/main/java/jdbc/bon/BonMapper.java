package jdbc.bon;

import jdbc.client.Client;
import jdbc.oras.Oras;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rursu on 8/3/2015.
 */
public class BonMapper implements RowMapper<Bon> {
    public Bon mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bon bon = new Bon();
        Client client = new Client();
        Oras oras = new Oras();
        bon.setCodBon(rs.getInt("B.ID"));
        bon.setData(rs.getString("B.DATA"));
        client.setCodClient(rs.getInt("C.ID"));
        client.setAdresa(rs.getString("C.ADRESA"));
        client.setNume(rs.getString("C.NUME"));
        oras.setCodOras(rs.getInt("O.ID"));
        oras.setNume(rs.getString("O.NUME"));
        client.setCodOras(oras);
        bon.setClient(client);
        return bon;
    }
}
