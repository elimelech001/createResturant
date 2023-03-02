
import java.util.ArrayList;
import java.util.Scanner;

public class Zone {
    Table[] tables;

    public Zone() {
        tables = new Table[0];
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
            addTable(table);
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
                costemerLeaving();
            } else if (num == 3) {
                tableMap();
            }
            System.out.println("press 0 to exit");
            System.out.println("press 1 if a costomer enterd");
            System.out.println("press 2 if a costomer left");
            System.out.println("press 3 to view all tables");
            num = in.nextInt();
        }
    }

    void addTable(Table table) {
        Table[] copyTables = new Table[tables.length + 1];
        for (int i = 0; i < tables.length; i++) {
            copyTables[i] = tables[i];
        }
        copyTables[tables.length] = table;
        tables = copyTables;
    }

    public Table[] getTables() {
        Table[] copyTable = new Table[tables.length];
        for (int i = 0; i < tables.length; i++) {
            copyTable[i] = tables[i];
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
        int tableNum = in.nextInt();
        while (!findTable(tableNum)) {
            System.out.println("please pick another table");
            tableNum = in.nextInt();
        }
        System.out.println("your table was chosen succesfuly");
        System.out.println();
        tableMap();
        return true;
    }

    void costemerLeaving() {
        ;
        Scanner in = new Scanner(System.in);
        tableMap();
        System.out.println("please enter the number table");
        int tableNum = in.nextInt();
        leaveTable(tableNum);
    }

    void tableMap() {
        for (int i = 0; i < tables.length; i++) {
            System.out.println(tables[i]);
        }
        System.out.println();
    }

    boolean allTablesOcupied(int peopleAmount) {
        for (int i = 0; i < tables.length; i++) {
            if (!tables[i].isOccupied() && tables[i].getSeats() >= peopleAmount) {
                return false;
            }
        }
        return true;
    }

    boolean findTable(int tableNum) {
        if (tableNum < 0 || tableNum >= tables.length) {
            return false;
        }
        if (!tables[tableNum].isOccupied()) {
            tables[tableNum].setOccupied(true);
            return true;
        }
        return false;
    }

    void waiterToTable(Waiter waiter, int tableNum) {
        tables[tableNum].setWaiter(waiter);
    }

    void billToTable(Bill bill, int tableNum) {
        tables[tableNum].setBill(bill);
    }

    void removeBill(Bill bill, int tableNum) {
        tables[tableNum].setBill(null);
    }

    void leaveTable(int tableNum) {
        tables[tableNum].setOccupied(false);
        System.out.println("costomer left succefuly");
        System.out.println();

    }

    public static void main(String[] args) {
        Zone foo = new Zone();
        foo.costomers();

    }

}
