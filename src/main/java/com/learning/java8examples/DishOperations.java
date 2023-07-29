package com.learning.java8examples;

import com.learning.models.Dish;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class DishOperations {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

        // 1. you can create a vegetarian menu by filtering all vegetarian dishes as follows
        List<Dish> vegMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        System.out.println("Veg Menu " + vegMenu);

        // 2. Selecting the first three dishes that have more than 300 calories

        List<Dish> firstThreeDishesOfMoreThanThreeHundredCalories = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("firstThreeDishesOfMoreThanThreeHundredCalories -> " + firstThreeDishesOfMoreThanThreeHundredCalories);

       // 3. Skipping the first two dishes that have more than 300 calories

        List<Dish> skipFirstTwoDishesOfMoreThanThreeHundredCalories = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("skipFirstTwoDishesOfMoreThanThreeHundredCalories -> " + skipFirstTwoDishesOfMoreThanThreeHundredCalories);

        // 4. How to get list of dishes names from List of Dish

        List<String> dishNames = menu.stream()
                .map(Dish::getName).collect(Collectors.toList());

        System.out.println("dishNames -> " + dishNames);

        // 5. What if you wanted to find out the length of the name of each dish?

        List<Integer> dishNamesLengthList = menu.stream()
                .map(Dish::getName).map(String::length).collect(Collectors.toList());

        System.out.println("dishNamesLengthList -> " + dishNamesLengthList);

        // 6. Total number of calories in all the dishes

        int calorieSum = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, (cal1, cal2) -> cal1 + cal2);

        System.out.println("Total calories of dishes -> "+ calorieSum);

        int calorieSum1 = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        System.out.println("Total calories of dishes -> "+ calorieSum1);

        Optional<Integer> caloriesSum2 = menu.stream()
                        .map(Dish::getCalories)
                                .reduce(Integer::sum);

        System.out.println("Total calories of dishes -> "+ caloriesSum2.get());

        int calorieSum3 = menu.stream()
                .mapToInt(Dish::getCalories).sum();

        System.out.println("Total calories of dishes -> "+ calorieSum3);

        // 7. Find out whether the menu has a vegetarian option

        System.out.println("Menu has veg option -> " + menu.stream().anyMatch(Dish::isVegetarian));

        // 8. Find out whether the menu is healthy (that is, all dishes are below 1000 calories)

        System.out.println("Menu is healthy(all dishes has calories less than 1000) ->" + menu.stream().allMatch(dish -> dish.getCalories() < 1000));
        System.out.println("Menu is healthy(all dishes has calories less than 1000) ->" + menu.stream().noneMatch(dish -> dish.getCalories() >= 1000));


        // 9. You may wish to find a dish that’s vegetarian

        Optional<Dish> vegDish = menu.stream().filter(Dish::isVegetarian).findAny();

        System.out.println("Any vegetarian dish -> "+ vegDish.get());
        vegDish.ifPresent(dish -> System.out.println(dish));

    }
}
