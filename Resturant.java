
public class Resturant {
    // array of tables
    GeneralWorkers generalWorkers;
    Zone zone;
    Shift shift;

    public Resturant() {
        generalWorkers = new GeneralWorkers();
        zone = new Zone();
        shift = new Shift(generalWorkers.getWorkers());

    }

    public static void main(String[] args) {

    }
}
