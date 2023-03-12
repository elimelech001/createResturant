import java.util.Scanner;

public class Resturant {
    GeneralWorkers generalWorkers;
    Zone zone;
    Shift shift;
    Dishes dishes;

    public Resturant() {
        generalWorkers = new GeneralWorkers();
        dishes = new Dishes();
        zone = new Zone(dishes);
        shift = new Shift(generalWorkers, zone);
        manage();
    }

    private void manage() {
        Scanner in = new Scanner(System.in);
        int num = -1;
        while (true) {
            if (num == 1) {
                generalWorkers.manageWorkors();
            } else if (num == 2) {
                dishes.manageDishes();
            } else if (num == 3) {
                shift.manageShift();
            } else if (num == 4) {
                shift = new Shift(generalWorkers,zone);

            } else if (num == 5) {
                zone.costomers();
            }

            System.out.println("---------------------------------");
            System.out.println("           RESTURANT             ");
            System.out.println("---------------------------------");
            System.out.println("press 1 to manage general workors");
            System.out.println("press 2 to manage dishes");
            System.out.println("press 3 to manage shift");
            System.out.println("press 4 to change a shift");
            System.out.println("press 5 to handle costemers");
            num = in.nextInt();
            in.close();
        }
        }
}
