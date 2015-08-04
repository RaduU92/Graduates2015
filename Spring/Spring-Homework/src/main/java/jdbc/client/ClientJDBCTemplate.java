package jdbc.client;

import jdbc.oras.Oras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/4/2015.
 */
@Repository
public class ClientJDBCTemplate {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(int codClient, String nume, String adresa, Oras oras) {
        String SQL = "INSERT INTO CLIENT (ID, NUME, ADRESA, COD_ORAS) VALUES (?, ?, ?, ?)";

        Integer orasID = oras == null ? null : oras.getCodOras();
        jdbcTemplate.update(SQL, codClient, nume, adresa, oras);
        System.out.println("Created Record CLIENT = " + codClient + " nume = " + nume);
    }

    public Client getClient(int codClient) {
        String SQL = "SELECT C.*, O.* FROM CLIENT C, ORAS O WHERE C.ID = ? AND C.COD_ORAS = O.ID";

        Client client = jdbcTemplate.queryForObject(SQL, new Object[]{codClient}, new ClientMapper());
        return client;
    }

    public List<Client> listClient() {
        String SQL = "SELECT * FROM CLIENT C, ORAS O WHERE C.COD_ORAS = O.ID";
        List<Client> clienti = jdbcTemplate.query(SQL, new ClientMapper());
        return clienti;
    }

    public void delete(Integer codClient) {
        String SQL = "DELETE FROM CLIENT WHERE ID = ?";
        jdbcTemplate.update(SQL, codClient);
        System.out.println("Deleted Record with ID = " + codClient);
    }

    public void update(Integer codClient, String nume, String adresa, Oras oras) {
        String SQL = "UPDATE CLIENT SET NUME = ?, ADRESA = ?, COD_ORAS = ?  WHERE ID = ?";
        jdbcTemplate.update(SQL, nume, adresa, oras.getCodOras(), codClient);
        System.out.println("Updated Record with ID = " + codClient);
    }
}
