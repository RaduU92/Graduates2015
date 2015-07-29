/**
 * Created by rursu on 7/29/2015.
 */
public class SendMailObserver extends Observer {
    public SendMailObserver(Worker worker) {
        this.worker = worker;
        worker.attach(this);
    }

    // Afisare mesaj daca s-a marit salariul.
    @Override
    public void update() {
        if((worker.getNetSalary() > worker.getOldNetSalary()) || (worker.getGrossSalary() > worker.getOldGrossSalary())) {
            System.out.println(" =>Marire de salariu!");
        }
    }
}
