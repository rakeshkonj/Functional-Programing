package com.rakesh.learn.functionalprograming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FPO2Structrured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

       int fpSum = addAllNumberFP(numbers);
        System.out.println("total sum"+":"+ fpSum);

        //Square every number in a list and find the sum of squares
        int sumOfSquares= addSquaresOfNumber(numbers);
        System.out.println("total sum of squares"+":"+ sumOfSquares);

        //Cube every number in a list and find the sum of cubes
        int sumOfCubes=addCubesOfNumbers(numbers);
        System.out.println("total sum of cubes"+":"+ sumOfCubes);

        //return the max number
        int maxNumber = findmaxNumList(numbers);
        System.out.println("maximum number in the list"+":"+ maxNumber);

        //return the min number
        int minNumber = findminNumList(numbers);
        System.out.println("minNumber number in the list"+":"+ minNumber);

       //Find Sum of Odd Numbers in a list
        int sumOdd = addAllOddNumbers(numbers);
        System.out.println("sum of odd numbers in the list"+":"+ sumOdd);

        //Create a List with Even Numbers Filtered from the Numbers List
        List<Integer> evenList = getEvenNumberListfromGivenList(numbers);
        System.out.println("Even list items:");
        evenList.forEach(System.out::println);

        //Create a List with lengths of all course titles.
        List<Integer> courseLenthList = courseLengthList(courses);
        System.out.println("course length list items:");
        courseLenthList.forEach(System.out::println);

        //print only distinct numbers
        System.out.println("printing distinct numbers:");
        numbers.stream().distinct().forEach(System.out::println);

        //print sorted numbers
        System.out.println("printing  numbers in sorted order:");
        numbers.stream().distinct().sorted().forEach(System.out::println);

        //sort courses
        System.out.println("printing  courses in sorted order:");
       // courses.stream().sorted().forEach(System.out::println);
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        //sort courses
        System.out.println("printing  courses in descending order:");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //sort courses
        System.out.println("printing  courses in based on course length:");
        courses.stream().sorted(Comparator.comparing(str -> str.length()))
                        .forEach(System.out::println);

    }

    private static List<Integer> courseLengthList(List<String> courses) {
        return courses.stream()
                      .map(c -> c.length())
                      .collect(Collectors.toList());
    }

    private static List<Integer> getEvenNumberListfromGivenList(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n % 2 ==0)
                      .collect(Collectors.toList());
    }

    private static int addAllOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n%2!=0)
                      .reduce(Integer.MIN_VALUE,(a,b) -> a + b );
    }

    private static int findminNumList(List<Integer> numbers) {
        return numbers.stream()
                      .reduce(Integer.MAX_VALUE,(a,b) -> a > b ? b : a);
    }

    private static int findmaxNumList(List<Integer> numbers) {
        return numbers.stream()
                      .reduce(Integer.MIN_VALUE,(x,y) -> x>y ? x : y);
    }

    private static int addCubesOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .map(n -> n*n*n)
                      .reduce(0,(a,b) ->a+b);
    }

    private static int addSquaresOfNumber(List<Integer> numbers) {
        return numbers.stream()
                .map( num -> num*num)
                .reduce(0,Integer::sum);
    }

    private static int sum(int a, int b){
        return a+b;
    }
    private static int addAllNumberFP(List<Integer> numbers) {
      return numbers.stream()
                    .reduce(0,Integer::sum);
    }






}
