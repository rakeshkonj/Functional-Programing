package com.rakesh.learn.functionalprograming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FB03BehavioralParametization {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        filterAndPrint(numbers, n -> n % 2 == 0);
        filterAndPrint(numbers, n -> n % 2 != 0);
        filterAndPrint(numbers, n -> n % 3 == 0);

        List<Integer> sqList = mapToCreateNewList(numbers, n -> n * n);
        List<Integer> cubeList = mapToCreateNewList(numbers, n -> n * n * n);
        List<Integer> addList = mapToCreateNewList(numbers, n -> n + n);
    }

    private static List<Integer> mapToCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
     return  numbers.stream()
              .map(mappingFunction)
              .collect(Collectors.toList());
    }


    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
