/**
 * Created by rursu on 7/24/2015.
 */
public class TVSeries {
    public String name;
    public String day;
    public String hour;
    public int productionYear;
    public String type;

    @Override
    public String toString() {
        return "TVSeries{" +
                "name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", productionYear=" + productionYear +
                ", type='" + type + '\'' +
                '}';
    }

    public TVSeries(String name, String day, String hour, int productionYear, String type) {
        this.name = name;
        this.day = day;
        this.hour = hour;
        this.productionYear = productionYear;
        this.type = type;
    }

    public String TVStoString() {
        return this.name + " - " + this.day + " - " + this.hour + " - " + this.productionYear + " - " + this.type;
    }
}
