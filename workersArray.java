import java.util.Scanner;

public class workersArray {

    static int getWorkerIndexByTZ(int TZ, Worker[] workers) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getTZ() == TZ) {
                return i;
            }
        }
        return -1;
    }

    static Worker[] addWorkors(Worker worker, Worker[] workers) {
        Worker[] copyWorkers = new Worker[workers.length + 1];
        for (int i = 0; i < workers.length; i++) {
            copyWorkers[i] = workers[i];
        }
        copyWorkers[copyWorkers.length - 1] = worker;
        return copyWorkers;
    }

    

    static void printWorkers(Worker[] workers) {
        int i = 0;
        for (i = 0; i < workers.length; i++) {
            System.out.println(workers[i]);
        }
        if (i == 0) {
            System.out.println("there are no workors");
        }
    }

    static Worker[] removeWorker(int index, Worker[] workers) {
        int counter = 0;
        Worker[] copyWorkers = new Worker[workers.length - 1];
        if (index < 0) {
            System.out.println("cant find workor");
            return workers;
        }
        for (int i = 0; i < workers.length; i++) {
            if (i != index) {
                copyWorkers[counter++] = workers[i];
            }

        }
        return copyWorkers;
    }
}
