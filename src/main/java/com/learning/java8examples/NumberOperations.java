package com.learning.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberOperations {
    public static void main(String[] args) {

        List<Integer> numbersList = Arrays.asList(12, 11, 5, 34, 12, 27, 89, 67, 56 , 54, 88, 4, 2, 76, 34);

        //1. Filter all even numbers from a list and makes sure that there are no duplicates
        List<Integer> distinctEvenNumbersList = numbersList.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("distinctEvenNumbersList ->"+ distinctEvenNumbersList);

        // OR

        Set<Integer> distinctEvenNumbersSet = numbersList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());

        System.out.println("distinctEvenNumbersSet ->"+ distinctEvenNumbersSet);

        // 2. given a list of numbers, finds the  squares that’s divisible by 3:

        List<Integer> squaresDivisbleByThree = numbersList.stream()
                .map(n -> n * n).filter(n -> n % 3 == 0).collect(Collectors.toList());

        System.out.println("squaresDivisbleByThree ->"+ squaresDivisbleByThree);

        // 3. given a list of numbers, finds the first square that’s divisible by 3:

        Optional<Integer> firstsquareDivisbleByThree = numbersList.stream()
                .map(n -> n * n).filter(n -> n % 3 == 0).findAny();

        System.out.println("firstsquareDivisbleByThree ->"+ firstsquareDivisbleByThree.get());
    }
}
