import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bill
 */
public class Bill {
    ArrayList<Dish> dishes = new ArrayList<Dish>();
    int tipPercent = 10;
    Dishes allDishes;
    

    public Bill(Dishes allDishes) {
        this.allDishes = allDishes;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void addDish() {
       int index= allDishes.IndexOfDish();
       dishes.add(allDishes.getDishes().get(index));

    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    public double getTip() {
        return dishesSum() * ((double)tipPercent / 100);
    }

    public double dishesSum() {
        int sum = 0;
        for (int i = 0; i < dishes.size(); i++) {
            sum += dishes.get(i).getPrice();
        }
        return sum;
    }

    public double total() {
        return dishesSum() + getTip();
    }

    public void printDishes() {
        System.out.println(disheString());
    }

    public String disheString() {
        String dish = "";
        for (int i = 0; i < dishes.size(); i++) {
            dish += dishes.get(i) + "\n";
        }
        return dish;
    }

    @Override
    public String toString() {
        return "Bill \n dishes=\n" + disheString() + ",\n tip=" + getTip() + "\n total " + total() + "";
    }

}