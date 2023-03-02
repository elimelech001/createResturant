import java.util.ArrayList;
import java.util.Scanner;

public class Dishes {
    ArrayList<Dish> dishes = new ArrayList<Dish>();

    public Dishes() {

    }

    public void manageDishes() {
        Scanner in = new Scanner(System.in);
        int num = -1;
        while (num != 0) {

            if (num == 1) {
                addDish(null);
            } else if (num == 2) {
                removeDish(null);
            } else if (num == 3) {
                printDishes();
            }
            System.out.println("press 0 to exit");
            System.out.println("press 1  to add a dish");
            System.out.println("press 2 to remove a dish");
            System.out.println("press 3 to view all dishes");
            num = in.nextInt();
        }
    }

    void addDish() {
        Dish dish = difineDish();
        dishes.add(dish);
    }

    public Dish difineDish() {
        Scanner in = new Scanner(System.in);
        String name;
        int price;
        Dish dish;
        System.out.println("name the dish");
        name = in.nextLine();
        System.out.println("price the dish");
        price = in.nextInt();
        dish = new Dish(name, price);
        return dish;
    }

    void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    public void printDishes() {
        for (int i = 0; i < dishes.size(); i++) {
            System.out.println(dishes.get(i));
        }
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }
}
