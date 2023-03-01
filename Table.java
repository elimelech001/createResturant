
public class Table {
    public static final int length = 0;
    private int seats;
    private boolean occupied;
    private int tableNumber;

    public Table(int seats, int tableNumber) {
        this.seats = seats;
        this.tableNumber = tableNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public static void main(String[] args) {
        Table table = new Table(1, 2);
        System.out.println(table.toString());
        System.out.print(table.toString());

    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        String setUp = "+--------------------------------------------+";
        String availeble = occupied ? "is ocupied" : "is availeble";
        return setUp+"\n| Table [seats=" + seats + "," + availeble + ", tableNumber=" + tableNumber + "]|\n"+setUp;
    }
   
}
