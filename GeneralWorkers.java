import java.util.Scanner;

public class GeneralWorkers {
    Worker[] workers;

    public GeneralWorkers() {
        workers = new Worker[0];
        setWorkers();
    }

   public void manageWorkors() {
        Scanner in = new Scanner(System.in);
        int num = -1;
        while (num != 0) {
            if (num == 1) {
                setWorkers();
            } else if (num == 2) {
                removeWorker();
            } else if (num == 3) {
                workersArray.printWorkers(workers);
            }
            System.out.println("GENERAL WORKORS");
            System.out.println("press 0 to exit");
            System.out.println("press 1 if you want to add workers");
            System.out.println("press 2 if you want to remove workors");
            System.out.println("press 3 to view all workers");
            num = in.nextInt();
        }
    }

    private void setWorkers() {
        Scanner in = new Scanner(System.in);
        Worker worker;
        int num = -1;
        while (num != 0) {

            if (num == 1) {
                worker = new ShiftManager();
                addWorkors(worker);
                difineWorker();
            } else if (num == 2) {
                worker = new Waiter();
                addWorkors(worker);
                difineWorker();
            } else if (num == 3) {
                worker = new Hostess();
                addWorkors(worker);
                difineWorker();

            } else if (num == 4) {
                worker = new Cook();
                addWorkors(worker);
                difineWorker();
            } else if (num == 5) {
                workersArray.printWorkers(workers);
            }
            System.out.println("GENERAL WORKORS");
            System.out.println("press 0 to exit");
            System.out.println("press 1 if you want to add a shiftmanager");
            System.out.println("press 2 if you want to add a waiter");
            System.out.println("press 3 if you want to add a hostess");
            System.out.println("press 4 if you want to add a cook");
            System.out.println("press 5 to view all workers");
            num = in.nextInt();
        }
    }

    void difineWorker() {
        Scanner in = new Scanner(System.in);
        String name;
        int TZ;
        String DOB;
        int index = workers.length - 1;
        System.out.println("enter your name");
        name = in.nextLine();
        System.out.println("enter your teudat zehut");
        TZ = in.nextInt();
        System.out.println("enter your date of birth");
        DOB = in.next();
        workers[index].setName(name);
        workers[index].setTZ(TZ);
        workers[index].setDOB(DOB);
    }

    public Worker[] getWorkers() {
        return workers;
    }

    void addWorkors(Worker worker) {
        workers = workersArray.addWorkors(worker, workers);
    }

    void removeWorker() {
        Scanner in = new Scanner(System.in);
        int tz;
        int index;
        workersArray.printWorkers(workers);
        System.out.println("pick a worker according to tz");
        tz = in.nextInt();
        index = workersArray.getWorkerIndexByTZ(tz, workers);
        workers = workersArray.removeWorker(index, workers);
        
    }

    
}
