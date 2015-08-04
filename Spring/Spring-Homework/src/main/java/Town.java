import jdbc.oras.Oras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by rursu on 8/4/2015.
 */
public class Town {
    @Autowired
    @Qualifier("city")
    Oras oras;

    public void printDetails() {
        System.out.println("Acest oras are id-ul: " + oras.getCodOras() + " si numele: " + oras.getNume());
    }

    public void initIt() {
        System.out.println("Quest - PostConstruct");
    }

    public void cleanUp() {
        System.out.println("Quest - PreDestroy");
    }
}
