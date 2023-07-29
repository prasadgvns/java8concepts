package com.learning.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Revised
public class FlatMapExamples {
    public static void main(String[] args) {
        List<String> productlist1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");
        List<String>  productlist2 = Arrays.asList("Scanner", "Projector", "Light Pen");
        List<String> productlist3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");
        List<String> productlist4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");

       List<String> allProducts = Stream.of(productlist1, productlist2, productlist3, productlist4)
               .flatMap(List::stream).collect(Collectors.toList());

        List<String> countriesList = Arrays.asList("Colombia", "Finland", "Greece", "Iceland", "Liberia", "Mali", "Mauritius");

        List<Character> distinctCharList = countriesList.stream()
                .map(w -> w.split("")).flatMap(Arrays::stream)
                .distinct()
                .map(s -> s.charAt(0))
                .collect(Collectors.toList());

        System.out.println("distinctCharList ->" + distinctCharList);
    }
}
