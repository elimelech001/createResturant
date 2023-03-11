import java.util.Scanner;

public class Shift {
    Worker[] allWorkers;
    Worker[] shiftWorkers;
    int workersIndex;
    int cooks = 2;
    int waiters = 3;
    int hostess = 1;

    public Shift(GeneralWorkers generalWorkers) {
        shiftWorkers = new Worker[0];
        this.allWorkers = generalWorkers.getWorkers();
        startShift();
    }

    void startShift() {
        while (!enoughWorkers()) {
            addWorkersFromGeneral();
        }
    }

    public void manageShift() {
        Scanner in = new Scanner(System.in);
        int num = -1;
        while (num != 0) {
            if (num == 1) {
                addWorkersFromGeneral();
            } else if (num == 2) {
                removeWorker();
            } else if (num == 3) {
                workersArray.printWorkers(shiftWorkers);
            }
            System.out.println("sHIFT");
            System.out.println("press 0 to exit");
            System.out.println("press 1 if you want to add workers");
            System.out.println("press 2 if you want to remove workors");
            System.out.println("press 3 to view all workers");
            num = in.nextInt();
        }
    }

    public void addWorkersFromGeneral() {
        Scanner in = new Scanner(System.in);
        int tz;
        int index;
        System.out.println("here are the general workors");
        System.out.println();

        workersArray.printWorkers(allWorkers);
        System.out.println("please give me a workor according to a tz");
        tz = in.nextInt();
        index = workersArray.getWorkerIndexByTZ(tz, allWorkers);
        if (index < 0) {
            System.out.println("teudat zehut not found");
            return;
        }
        shiftWorkers = workersArray.addWorkors(allWorkers[index], shiftWorkers);
        System.out.println("here are the shift workors");
        workersArray.printWorkers(shiftWorkers);

    }

    public void removeWorker() {
        Scanner in = new Scanner(System.in);
        int tz;
        int index;
        workersArray.printWorkers(shiftWorkers);
        System.out.println("pick a worker according to teudat zehut");
        System.out.println();
        tz = in.nextInt();
        index = workersArray.getWorkerIndexByTZ(tz, shiftWorkers);
        shiftWorkers = workersArray.removeWorker(index, shiftWorkers);
        System.out.println("here are the shift workors");
        System.out.println();
        workersArray.printWorkers(shiftWorkers);
    }

    void waiterToTable(Table[] tables) {
        workersArray.getWorkerIndexByTZ(2, shiftWorkers);

    }

    public boolean enoughWorkers() {
        for (int i = 0; i < shiftWorkers.length; i++) {
            if (shiftWorkers[i] instanceof Waiter) {
                waiters--;
            } else if (shiftWorkers[i] instanceof Hostess) {
                hostess--;
            } else if (shiftWorkers[i] instanceof Cook) {
                cooks--;
            }

        }

        if (cooks <= 0 && waiters <= 0 && hostess <= 0) {
            return true;
        } else {
            if (cooks > 0) {
                System.out.println("your missing " + (Math.abs(cooks)) + " cheffs");

            }
            if (waiters > 0) {
                System.out.println("your missing " + (Math.abs(waiters)) + " waiters");

            }
            if (hostess > 0) {
                System.out.println("your missing " + (Math.abs(hostess)) + " hosteess");

            }
            return false;
        }

    }

    public static void main(String[] args) {
        GeneralWorkers generalWorkers = new GeneralWorkers();
        Shift shift = new Shift(generalWorkers);
        shift.manageShift();

    }
}
