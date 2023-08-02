package com.learning.java8examples;

import com.learning.models.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorsExample {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

        long numberOfDishes = menu.stream().collect(counting());

        System.out.println("numberOfDishes ->" + numberOfDishes);

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> maxCalorieDish = menu.stream().collect(maxBy(dishComparator));

        System.out.println("maxCalorieDish ->" + maxCalorieDish.get());

        Optional<Dish> minCalorieDish = menu.stream().collect(minBy(dishComparator));

        System.out.println("minCalorieDish ->" + minCalorieDish.get());

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        System.out.println("totalCalories ->" + totalCalories);

        double avgCalorie = menu.stream().collect(averagingDouble(Dish::getCalories));

        System.out.println("avgCalorie ->" + avgCalorie);

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        System.out.println("menuStatistics ->" + menuStatistics);

        String shortMenu = menu.stream().map(Dish::getName).collect(joining());

        System.out.println("shortMenu ->" + shortMenu);

        String shortMenuWithComma = menu.stream().map(Dish::getName).collect(joining(","));

        System.out.println("shortMenuWithComma ->" + shortMenuWithComma);

        // Generic reduce example

        int totalDishCalories = menu.stream().collect(reducing(0, Dish::getCalories,(i,j) -> i + j ));

        Optional<Dish> mostCaloriedDish = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1: d2));


    }
}
