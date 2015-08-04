import jdbc.dvd.DVD;
import jdbc.dvd.DvdJDBCTemplate;
import jdbc.oras.OrasJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rursu on 8/4/2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext a = new ClassPathXmlApplicationContext("application-context.xml");
        OrasJDBCTemplate o = a.getBean("orasJDBCTemplate", OrasJDBCTemplate.class);

        //o.create(4,"Timisoara");
        DvdJDBCTemplate d = a.getBean("dvdJDBCTemplate",DvdJDBCTemplate.class);
        DVD dvd = d.getDVD(1);
        System.out.println(dvd.getTitlu());

        Town town = (Town) a.getBean("town");
        town.printDetails();

    }
}
