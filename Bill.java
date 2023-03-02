import java.util.ArrayList;

/**
 * Bill
 */
public class Bill {
    ArrayList<Dish> dishes = new ArrayList<Dish>();

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < dishes.size(); i++) {
            sum += dishes.get(i).getPrice();
        }
        return sum;
    }

    public void printBill() {
        for (int i = 0; i < dishes.size(); i++) {
            System.out.println(dishes.get(i));
        }
    }

}