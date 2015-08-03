package jdbc.categorie;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/3/2015.
 */
public interface CategorieDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Graduate table.
     */
    public void create(int codCategorie, String denumireCategorie);

    /**
     * This is the method to be used to list down
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public Categorie getCategorie(int codCategorie);

    /**
     * This is the method to be used to list down
     * all the records from the Graduate table.
     */
    public List<Categorie> listCategorie();

    /**
     * This is the method to be used to delete
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public void delete(Integer codCategorie);

    /**
     * This is the method to be used to update
     * a record into the Graduate table.
     */
    public void update(Integer codCategorie, String denumireCategorie);
}
