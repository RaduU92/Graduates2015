package jdbc.client;

import jdbc.oras.Oras;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by rursu on 8/3/2015.
 */
public interface ClientDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Graduate table.
     */
    public void create(int codClient, String nume, String adresa, Oras oras);

    /**
     * This is the method to be used to list down
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public Client getClient(int codClient);

    /**
     * This is the method to be used to list down
     * all the records from the Graduate table.
     */
    public List<Client> listClient();

    /**
     * This is the method to be used to delete
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public void delete(Integer codClient);

    /**
     * This is the method to be used to update
     * a record into the Graduate table.
     */
    public void update(Integer codClient, String nume, String adresa, Oras oras);
}
