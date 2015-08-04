package jdbc.categorie;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 03.08.2015.
 */
public class CategorieJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(int codCategorie, String denumireCategorie) {
        String SQL = "INSERT INTO BON (ID, DENUMIRE) values (?, ?)";

        jdbcTemplate.update(SQL, codCategorie, denumireCategorie);
        System.out.println("Created Record Categorie = " + codCategorie + " denumire = " + denumireCategorie);
    }

    public Categorie getCategorie(int codCategorie) {
        String SQL = "SELECT * FROM CATEGORIE WHERE ID = ?";

        Categorie categorie = jdbcTemplate.queryForObject(SQL, new Object[]{codCategorie}, new CategorieMapper());
        return categorie;
    }

    public List<Categorie> listCategorie() {
        String SQL = "SELECT * FROM CATEGORIE";
        List<Categorie> categorii = jdbcTemplate.query(SQL, new CategorieMapper());
        return categorii;
    }

    public void delete(Integer codCategorie) {
        String SQL = "DELETE FROM CATEGORIE WHERE ID = ?";
        jdbcTemplate.update(SQL, codCategorie);
        System.out.println("Deleted Record with ID = " + codCategorie);
    }

    public void update(Integer codCategorie, String denumireCategorie) {
        String SQL = "UPDATE CATEGORIE SET DENUMIRE = ? WHERE ID = ?";
        jdbcTemplate.update(SQL, denumireCategorie, codCategorie);
        System.out.println("Updated Record with ID = " + codCategorie);
    }
}