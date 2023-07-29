package com.learning.java8examples;

import com.learning.models.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quizes {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

        // Quiz 1:  How would you use streams to filter the first two meat dishes?

        List<Dish> firstTwoMeatDishes = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.FISH)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("firstTwoMeatDishes -> "+ firstTwoMeatDishes);

        //Quiz 2: Given a list of numbers, how would you return a list of the square of each number?

        List<Integer> numbersList = Arrays.asList(12, 11, 5, 34, 12, 27, 89, 67, 56 , 54, 88, 4, 2, 76, 34);

        List<Integer> squareNumbersList = numbersList.stream().map(n -> n * n).collect(Collectors.toList());

        System.out.println("squareNumbersList -> "+ squareNumbersList);

        //Quiz 3: Given two lists of numbers, how would you return all pairs of numbers?

        List<Integer> secondNumbersList = Arrays.asList(15, 43, 37, 18);

        numbersList.stream()
                .flatMap(n1 -> secondNumbersList.stream()
                .map(n2 -> new int[]{n1, n2}))
                .forEach(t -> System.out.println("{"+t[0] +","+t[1]+ "}"));

        // Quiz 4: . How would you extend the previous example to return only pairs whose sum is divisible by 3?

        System.out.println("Pairs Divisible by 3");
        numbersList.stream()
                .flatMap(n1 -> secondNumbersList.stream()
                        .map(n2 -> new int[]{n1, n2}))
                .filter(t -> (t[0] + t[1]) % 3 == 0)
                .forEach(t -> System.out.println("{"+t[0] +","+t[1]+ "}"));

    }
}
