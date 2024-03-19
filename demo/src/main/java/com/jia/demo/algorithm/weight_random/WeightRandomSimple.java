package com.jia.demo.algorithm.weight_random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightRandomSimple {

  public static void main(String[] args) {
    List<Item> items = new ArrayList<>();
    items.add(new Item("A", 3));
    items.add(new Item("B", 5));
    items.add(new Item("C", 2));

    int totalWeight = 0;
    for (Item item : items) {
      totalWeight += item.getWeight();
    }

    Random random = new Random();
    int randomNumber = random.nextInt(totalWeight) + 1;

    int accumulatedWeight = 0;
    for (Item item : items) {
      accumulatedWeight += item.getWeight();
      if (randomNumber <= accumulatedWeight) {
        System.out.println("Randomly selected item: " + item.getName());
        break;
      }
    }
  }
}
