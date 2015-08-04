package jdbc.inchiriere;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/4/2015.
 */
public class InchiriereJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(int codInchiriere, int codBon, int codFilm) {
        String SQL = "INSERT INTO INCHIRIERE (ID, COD_BON, COD_FILM) VALUES (?, ?, ?)";

        jdbcTemplate.update(SQL, codInchiriere, codBon, codFilm);
        System.out.println("Created Record Inchiriere = " + codInchiriere);
    }

    public Inchiriere getInchiriere(int codInchiriere) {
        String SQL = "SELECT * FROM INCHIRIERE I, FILM F, BON B, CLIENT C, ORAS O WHERE I.ID = ? AND I.COD_BON = B.ID AND I.COD_FILM = F.ID AND B.COD_CLIENT = C.ID AND C.COD_ORAS = O.ID";

        Inchiriere inchiriere = jdbcTemplate.queryForObject(SQL, new Object[]{codInchiriere}, new InchiriereMapper());
        return inchiriere;
    }

    public List<Inchiriere> listInchiriere() {
        String SQL = "SELECT * FROM INCHIRIERE I, FILM F, BON B, CLIENT C, ORAS O WHERE I.COD_BON = B.ID AND I.COD_FILM = F.ID AND B.COD_CLIENT = C.ID AND C.COD_ORAS = O.ID";
        List<Inchiriere> dvdCategories = jdbcTemplate.query(SQL, new InchiriereMapper());
        return dvdCategories;
    }

    public void delete(Integer codInchiriere) {
        String SQL = "DELETE FROM INCHIRIERE WHERE ID = ?";
        jdbcTemplate.update(SQL, codInchiriere);
        System.out.println("Deleted Record with ID = " + codInchiriere);
    }

    public void update(int codInchiriere, int codBon, int codFilm) {
        String SQL = "UPDATE INCHIRIERE SET COD_BON = ?, COD_FILM = ?  WHERE ID = ?";
        jdbcTemplate.update(SQL, codBon, codFilm, codInchiriere);
        System.out.println("Updated Record with ID = " + codInchiriere);
    }
}
