package jdbc.client;

import jdbc.oras.Oras;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rursu on 8/4/2015.
 */
public class ClientMapper implements RowMapper<Client> {
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        Oras oras = new Oras();
        client.setCodClient(rs.getInt("C.ID"));
        client.setAdresa(rs.getString("C.ADRESA"));
        client.setNume(rs.getString("C.NUME"));
        oras.setCodOras(rs.getInt("O.ID"));
        oras.setNume(rs.getString("O.NUME"));
        client.setCodOras(oras);
        return client;
    }
}
