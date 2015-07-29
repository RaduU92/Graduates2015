import java.util.ArrayList;
import java.util.List;

/**
 * Created by rursu on 7/29/2015.
 */
public class Worker {
    private List<Observer> observers = new ArrayList<Observer>();
    public int netSalary = 0;
    public int oldNetSalary = 0;
    public int grossSalary = 0;
    public int oldGrossSalary = 0;

    public int getNetSalary() {
        return netSalary;
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    public void setNetSalary(int netSalary) {
        this.netSalary = netSalary;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
        notifyAllObservers();
    }

    public int getOldNetSalary() {
        return oldNetSalary;
    }

    public void setOldNetSalary(int oldNetSalary) {
        this.oldNetSalary = oldNetSalary;
    }

    public int getOldGrossSalary() {
        return oldGrossSalary;
    }

    public void setOldGrossSalary(int oldGrossSalary) {
        this.oldGrossSalary = oldGrossSalary;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
