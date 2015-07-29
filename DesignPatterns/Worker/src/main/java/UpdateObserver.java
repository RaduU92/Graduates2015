/**
 * Created by rursu on 7/29/2015.
 */
public class UpdateObserver extends Observer {
    public UpdateObserver(Worker worker) {
        this.worker = worker;
        worker.attach(this);
    }

    // calculeaza noul salariu net in functie de salariul brut si face update si la oldGrossSalary.
    @Override
    public void update() {
        if (worker.getGrossSalary() != worker.getOldGrossSalary()) {
            worker.setNetSalary((worker.getGrossSalary() * 82) / 100);
            worker.setOldGrossSalary(worker.getGrossSalary());
            System.out.println(" Noul salariu net este: " + worker.getNetSalary());
        }
    }
}
