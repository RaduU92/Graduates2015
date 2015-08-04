package jdbc.dvd_categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/4/2015.
 */
@Repository
public class DVDCategorieTemplate {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(int codDVDCategorie, int codDVD, int codCategorie) {
        String SQL = "INSERT INTO FILM_CATEG (ID, COD_DVD, COD_CATEGORIE) VALUES (?, ?, ?)";

        jdbcTemplate.update(SQL, codDVDCategorie, codDVD, codCategorie);
        System.out.println("Created Record DVDCategorie = " + codDVDCategorie);
    }

    public DVDCategorie getDVDCategorie(int codDVDCategorie) {
        String SQL = "SELECT * FROM FILM_CATEG D, FILM F, CATEGORIE C WHERE D.ID = ? AND D.COD_DVD = F.ID AND D.COD_CATEGORIE = C.ID";

        DVDCategorie dvdCategorie = jdbcTemplate.queryForObject(SQL, new Object[]{codDVDCategorie}, new DVDCategorieMapper());
        return dvdCategorie;
    }

    public List<DVDCategorie> listDVDCategorie() {
        String SQL = "SELECT * FROM FILM_CATEG";
        List<DVDCategorie> dvdCategories = jdbcTemplate.query(SQL, new DVDCategorieMapper());
        return dvdCategories;
    }

    public void delete(Integer codDVDCategorie) {
        String SQL = "DELETE FROM FILM_CATEG WHERE ID = ?";
        jdbcTemplate.update(SQL, codDVDCategorie);
        System.out.println("Deleted Record with ID = " + codDVDCategorie);
    }

    public void update(int codDVDCategorie, int codDVD, int codCategorie) {
        String SQL = "UPDATE FILM_CATEG SET COD_DVD = ?, COD_CATEGORIE = ?  WHERE ID = ?";
        jdbcTemplate.update(SQL, codDVD, codCategorie, codDVDCategorie);
        System.out.println("Updated Record with ID = " + codDVDCategorie);
    }
}
