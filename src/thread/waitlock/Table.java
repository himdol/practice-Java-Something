package thread.waitlock;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Table {

  String[] dishName = {"donut", "donut", "bugger"};
  final int MAX_FOOD = 6;

  private ArrayList<String> dishes = new ArrayList<>();

  public void add(String dish) {
    if (dishes.size() >= MAX_FOOD) {
      return;
    }
    dishes.add(dish);
    System.out.println("Dishes:" + dishes.toString());
  }

  public boolean remove(String dishName) {

    dishes.stream().filter(v -> dishName.equals(v))
            .collect(Collectors.toList())
            .forEach(st -> remove(st));
//    for (int i = 0; i < dishes.size(); i++) {
//      if (dishName.equals(dishes.get(i))) {
//        dishes.remove(i);
//        return true;
//      }
//    }
    return false;
  }
  public int dishNum() {return dishName.length;}

}


