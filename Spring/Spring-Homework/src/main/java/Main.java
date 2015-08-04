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

        o.create(3,"Brasov");

    }
}
