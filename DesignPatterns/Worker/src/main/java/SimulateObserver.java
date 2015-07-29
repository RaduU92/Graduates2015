/**
 * Created by rursu on 7/29/2015.
 */
public class SimulateObserver extends Observer {
    public SimulateObserver(Worker worker) {
        this.worker = worker;
        worker.attach(this);
    }

    // Afiseaza mesaj daca salariul net depaseste pragul de 5000 si seteaza valoarea oldNetSalary egala cu netSalary
    @Override
    public void update() {
        if((worker.getNetSalary() >= 5000) && (worker.getOldNetSalary() < 5000)) {
            System.out.println(" =>Simulare de credit.");
        }
        worker.setOldNetSalary(worker.getNetSalary());
    }
}
