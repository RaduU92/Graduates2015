import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by rursu on 8/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        java.util.Date data = new java.util.Date();
        Date date = new Date(data.getTime());
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(d.format(date));
        System.out.println(getDate(1990, 1, 1));
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simple.format(getDate(1990, 1, 2)));
        java.sql.Timestamp time = new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println(time);

        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        System.out.println(date2);
        System.out.println(stamp);
    }

    public static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return new Date(calendar.getTimeInMillis());
    }
}
