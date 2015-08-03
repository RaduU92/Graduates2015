package jdbc.dvd_categorie;

import jdbc.categorie.Categorie;
import jdbc.dvd.DVD;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/3/2015.
 */
public interface DVDCategorieDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Graduate table.
     */
    public void create(int id, DVD dvd, Categorie categorie);

    /**
     * This is the method to be used to list down
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public DVDCategorie getDVDCategorie(int id);

    /**
     * This is the method to be used to list down
     * all the records from the Graduate table.
     */
    public List<DVDCategorie> listDVDCategorie();

    /**
     * This is the method to be used to delete
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public void delete(Integer id);

    /**
     * This is the method to be used to update
     * a record into the Graduate table.
     */
    public void update(Integer id, DVD dvd, Categorie categorie);
}
