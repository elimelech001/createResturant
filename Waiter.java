
public class Waiter extends Worker {
    Table[] Table = new Table[3];

    public Waiter() {

    }

    @Override
    public String toString() {
        return "Waiter [name=" + name + ", TZ=" + TZ + ", DOB=" + DOB + "]";
    }
}
