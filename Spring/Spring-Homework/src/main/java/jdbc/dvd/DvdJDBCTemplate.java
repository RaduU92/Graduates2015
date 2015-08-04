package jdbc.dvd;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/4/2015.
 */
public class DvdJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(int codDVD, String titlu, String descriere, int durata, int numarExemplare, int tarifZilnic) {
        String SQL = "INSERT INTO FILM (ID, TITLU, DESCRIERE, DURATA, NUMAR_EXEMPLARE, TARIF_ZILNIC) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL, codDVD, titlu, descriere, durata, numarExemplare, tarifZilnic);
        System.out.println("Created Record DVD = " + codDVD + " titlu = " + titlu);
    }

    public DVD getDVD(int codDVD) {
        String SQL = "SELECT * FROM FILM WHERE ID = ?";

        DVD dvd = jdbcTemplate.queryForObject(SQL, new Object[]{codDVD}, new DVDMapper());
        return dvd;
    }

    public List<DVD> listDVDs() {
        String SQL = "SELECT * FROM FILM";
        List<DVD> dvds = jdbcTemplate.query(SQL, new DVDMapper());
        return dvds;
    }

    public void delete(Integer codDVD) {
        String SQL = "DELETE FROM FILM WHERE ID = ?";
        jdbcTemplate.update(SQL, codDVD);
        System.out.println("Deleted Record with ID = " + codDVD);
    }

    public void update(int codDVD, String titlu, String descriere, int durata, int numarExemplare, int tarifZilnic) {
        String SQL = "UPDATE FILM SET TITLU = ?, DESCRIERE = ?, DURATA = ?, NUMAR_EXEMPLARE = ?, TARIF_ZILNIC = ?  WHERE ID = ?";
        jdbcTemplate.update(SQL, titlu, descriere, durata, numarExemplare, tarifZilnic, codDVD);
        System.out.println("Updated Record with ID = " + codDVD);
    }
}
