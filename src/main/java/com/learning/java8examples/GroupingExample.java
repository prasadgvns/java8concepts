package com.learning.java8examples;

import com.learning.models.Dish;
import com.learning.models.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class GroupingExample {
    public static void main(String[] args) {
        // Grouping by imperative programming
        Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();

        List<Transaction> transactions = Transaction.getTransactionsList();
        List<Dish> menu = Dish.getMenu();

        for(Transaction transaction : transactions){
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionByCurrencies.get(currency);

            if(transactionsForCurrency == null){
                transactionsForCurrency = new ArrayList<>();
                transactionByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        System.out.println("transactionByCurrencies ->"+transactionByCurrencies);

        // using java8

        Map<Currency, List<Transaction>> transactionsByCurrency1 = transactions
                .stream()
                .collect(groupingBy(Transaction::getCurrency));

        System.out.println("transactionByCurrencies1 ->"+transactionByCurrencies);

        Map<Integer, List<Transaction>> transactionsByYear = transactions
                .stream()
                .collect(groupingBy(Transaction::getYear));

        System.out.println("transactionsByYear ->"+transactionsByYear);

        // Count the number of dishes using Collectors

        long howManyDishes = menu.stream().collect(counting());

        // Finding Maximum and minimum using Collectors

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu
                .stream()
                .collect(maxBy(dishCaloriesComparator));

        // Finding sum of calories of all the dishes using Collectors

        int totalCalories = menu
                .stream()
                .collect(summingInt(Dish::getCalories));

        // Calculating avg calories of dishes

        double avgCalories = menu
                .stream()
                .collect(averagingDouble(Dish::getCalories));

        // count the elements in a menu, obtain the sum, average, maximum and minimum in a single operations

        IntSummaryStatistics menuStatistics = menu
                .stream()
                .collect(summarizingInt(Dish::getCalories));

        System.out.println("menuStatistics ->" + menuStatistics);
    }
}
