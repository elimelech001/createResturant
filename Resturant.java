import java.util.Scanner;

public class Resturant {
    // array of tables
    GeneralWorkers generalWorkers;
    Zone zone;
    Shift shift;
    Dishes dishes;

    public Resturant() {
        generalWorkers = new GeneralWorkers();
        dishes = new Dishes();
        zone = new Zone(dishes);
        shift = new Shift(generalWorkers);
        manage();
    }

    void manage() {
        Scanner in = new Scanner(System.in);
        int num = -1;
        while (num != 0) {

            if (num == 1) {
                generalWorkers.manageWorkors();
            } else if (num == 2) {
                dishes.manageDishes();
            } else if (num == 3) {
                shift.manageShift();
            } else if (num == 4) {
                zone.costomers();
            }
            System.out.println("press 0 to exit");
            System.out.println("press 1 if to manage general workors");
            System.out.println("press 2 to manage dishes");
            System.out.println("press 3 to manage shift");
            System.out.println("press 4 to handle costemers");
            num = in.nextInt();
        }
    }
}
