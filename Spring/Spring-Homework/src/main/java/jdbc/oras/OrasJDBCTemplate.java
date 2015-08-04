package jdbc.oras;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/4/2015.
 */
public class OrasJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(int codOras, String nume) {
        String SQL = "INSERT INTO ORAS (ID, NUME) VALUES (?, ?)";

        jdbcTemplate.update(SQL, codOras, nume);
        System.out.println("Created Record Oras = " + codOras);
    }

    public Oras getOras(int codOras) {
        String SQL = "SELECT * FROM ORAS WHERE ID = ?";

        Oras oras = jdbcTemplate.queryForObject(SQL, new Object[]{codOras}, new OrasMapper());
        return oras;
    }

    public List<Oras> listOras() {
        String SQL = "SELECT * FROM ORAS";
        List<Oras> orase = jdbcTemplate.query(SQL, new OrasMapper());
        return orase;
    }

    public void delete(Integer codOras) {
        String SQL = "DELETE FROM ORAS WHERE ID = ?";
        jdbcTemplate.update(SQL, codOras);
        System.out.println("Deleted Record with ID = " + codOras);
    }

    public void update(int codOras, String nume) {
        String SQL = "UPDATE ORAS SET NUME = ?  WHERE ID = ?";
        jdbcTemplate.update(SQL, codOras, nume);
        System.out.println("Updated Record with ID = " + codOras);
    }
}
