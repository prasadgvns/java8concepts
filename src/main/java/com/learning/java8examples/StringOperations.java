package com.learning.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringOperations {
    public static void main(String[] args) {

        List<String> wordList = Arrays.asList("guru", "prasad", "pandey","shweta","tripathi");

        //1. Given a list of words, you’d like to return a list of the number of characters for each word.

        List<Integer> numberOfCharacters = wordList.stream()
                .map(String::length).collect(Collectors.toList());

        System.out.println("numberOfCharacters ->"+ numberOfCharacters);
    }
}
