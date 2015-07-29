/**
 * Created by rursu on 7/29/2015.
 */
public class Main {
    public static void main(String args[]) {
        Worker worker = new Worker();
        int salary = 100;

        new UpdateObserver(worker);
        new SendMailObserver(worker);
        new SimulateObserver(worker);

        System.out.println("---------------\nModificare salariu brut la valoarea " + salary + "\n");
        worker.setGrossSalary(salary);

        salary = 8000;
        System.out.println("---------------\nModificare salariu brut la valoarea " + salary + "\n");
        worker.setGrossSalary(salary);

        salary = 1000;
        System.out.println("---------------\nModificare salariu brut la valoarea " + salary + "\n");
        worker.setGrossSalary(salary);

        salary = 9000;
        System.out.println("---------------\nModificare salariu brut la valoarea " + salary + "\n");
        worker.setGrossSalary(salary);
    }
}
