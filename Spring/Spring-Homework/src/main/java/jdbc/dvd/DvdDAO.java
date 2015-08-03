package jdbc.dvd;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/3/2015.
 */
public interface DvdDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Graduate table.
     */
    public void create(int codDVD, String titlu, String descriere, int durata, int numarExemplare, int tarifZilnic);

    /**
     * This is the method to be used to list down
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public DVD getDVD(int codDVD);

    /**
     * This is the method to be used to list down
     * all the records from the Graduate table.
     */
    public List<DVD> listDVD();

    /**
     * This is the method to be used to delete
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public void delete(Integer codDVD);

    /**
     * This is the method to be used to update
     * a record into the Graduate table.
     */
    public void update(Integer codDVD, String titlu, String descriere, Integer durata, Integer numarExemplare, Integer tarifZilnic);
}
