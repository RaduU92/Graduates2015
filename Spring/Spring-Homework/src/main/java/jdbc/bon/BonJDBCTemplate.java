package jdbc.bon;

import jdbc.client.Client;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/3/2015.
 */
public class BonJDBCTemplate implements BonDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(int codBon, Client client, String data) {
        String SQL = "INSERT INTO BON (ID, DATA, COD_CLIENT) values (?, ?, ?)";

        Integer clientID = client == null ? null : client.getCodClient();
        jdbcTemplate.update(SQL, codBon, data, clientID);
        System.out.println("Created Record BON = " + codBon + " Client = " + clientID + " data = " + data);
    }

    public Bon getBon(int codBon) {
        String SQL = "SELECT B.*, C.*, O.* FROM BON B , CLIENT C, ORAS O WHERE B.ID = ? AND B.COD_CLIENT = C.ID AND C.COD_ORAS = O.ID";

        Bon bon = jdbcTemplate.queryForObject(SQL, new Object[]{codBon}, new BonMapper());
        return bon;
    }

    public List<Bon> listBon() {
        String SQL = "SELECT * FROM BON B, CLIENT C, ORAS O WHERE B.COD_CLIENT = C.ID AND C.COD_ORAS = O.ID";
        List<Bon> bonuri = jdbcTemplate.query(SQL, new BonMapper());
        return bonuri;
    }

    public void delete(Integer codBon) {
        String SQL = "DELETE FROM BON WHERE ID = ?";
        jdbcTemplate.update(SQL, codBon);
        System.out.println("Deleted Record with ID = " + codBon);
    }

    public void update(Integer codBon, Client client, String data) {
        String SQL = "UPDATE BON SET DATA = ?, COD_CLIENT = ?  WHERE ID = ?";
        jdbcTemplate.update(SQL, data, client.getCodClient(), codBon);
        System.out.println("Updated Record with ID = " + codBon);
    }
}
