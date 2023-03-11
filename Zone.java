
import java.util.ArrayList;
import java.util.Scanner;

public class Zone {
    // Table[] tables;
    ArrayList<Table> tables = new ArrayList<Table>();
    Dishes allDishes;

    public Zone(Dishes dishes) {
        allDishes = dishes;
        setTable();
    }

    public void setTable() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter how many seats are in the table");
        System.out.println();

        int seats = in.nextInt();
        int index = 0;
        Table table;
        while (seats > 0) {
            table = new Table(seats, index++);
            tables.add(table);
            System.out.println("enter 0 to exit");
            System.out.println("enter how many seats are in the next table");
            System.out.println();

            seats = in.nextInt();
        }
    }

    void costomers() {
        Scanner in = new Scanner(System.in);
        int num = -1;
        while (num != 0) {

            if (num == 1) {
                costemerEnterd();
            } else if (num == 2) {
                addDish();
            } else if (num == 3) {
                costemerLeaving();
            } else if (num == 4) {
                tableMap();
            }

            System.out.println("ZONE");
            System.out.println("press 0 to exit");
            System.out.println("press 1 if a costomer enterd");
            System.out.println("press 2 to add a dish");
            System.out.println("press 3 if a costomer left");
            System.out.println("press 4 to view all tables");
            num = in.nextInt();
        }
    }

    public Table[] getTables() {
        Table[] copyTable = new Table[tables.size()];
        for (int i = 0; i < tables.size(); i++) {
            copyTable[i] = tables.get(i);
        }
        return copyTable;
    }

    boolean costemerEnterd() {
        Scanner in = new Scanner(System.in);
        System.out.println("how many people are there");
        int peopleAmount = in.nextInt();
        if (allTablesOcupied(peopleAmount)) {
            System.out.println("sorry there is no table that can fit this guest");
            System.out.println();
            return false;
        }
        System.out.println("pick a table");
        System.out.println();

        tableMap();

        while (!findTable(peopleAmount)) {
            System.out.println("please pick another table");
        }
        System.out.println("your table was chosen succesfuly");
        tableMap();
        return true;
    }

    void tableMap() {
        for (int i = 0; i < tables.size(); i++) {

            System.out.println(tables.get(i));

        }
        System.out.println();
    }

    boolean allTablesOcupied(int peopleAmount) {
        for (int i = 0; i < tables.size(); i++) {
            if (!tables.get(i).isOccupied() && tables.get(i).getSeats() >= peopleAmount) {
                return false;
            }
        }
        return true;
    }

    boolean findTable(int peopleAmount) {
        Bill bill;
        int tableNum = getTableNum();
        if (tableNum == -1) {
            return false;
        }

        if (!tables.get(tableNum).isOccupied() && tables.get(tableNum).getSeats() >= peopleAmount) {
            bill = new Bill(allDishes);
            tables.get(tableNum).setOccupied(true);
            tables.get(tableNum).setBill(bill);
            return true;
        }
        return false;
    }

    int getTableNum() {
        Scanner in = new Scanner(System.in);
        int index;
        tableMap();
        System.out.println("pick a table number");
        index = in.nextInt();
        if (index > 0 && index <= tables.size()) {
            return index;
        }
        System.out.println("index not found");
        return -1;
    }

    void waiterToTable(Waiter waiter, int tableNum) {
        tables.get(tableNum).setWaiter(waiter);
    }

    void removeBill(int tableNum) {
        tables.get(tableNum).setBill(null);
    }

    void addDish() {
        int tableNum = getTableNum();
        if (tableNum != -1) {
            tables.get(tableNum).getBill().addDish();
        }

    }

    void costemerLeaving() {
        int tableNum = getTableNum();
        if (tableNum == -1 || !tables.get(tableNum).isOccupied())
            return;
        tables.get(tableNum).setOccupied(false);
        System.out.println(tables.get(tableNum).getBill());
        removeBill(tableNum);
        System.out.println("costomer left succefuly");
        System.out.println();

    }

    public static void main(String[] args) {
        Dishes dishes = new Dishes();

        Zone foo = new Zone(dishes);
        foo.costomers();

    }

}
