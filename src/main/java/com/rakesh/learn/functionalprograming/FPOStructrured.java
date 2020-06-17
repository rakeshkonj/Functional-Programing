package com.rakesh.learn.functionalprograming;

import java.util.List;

public class FPOStructrured {
    public static void main(String[] args) {
        List<Integer> numbers
                = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
        /*printAllEvennumber(number);
        printAllnumberFunctional(number);
        printAllnumberFunctionalMethodRef(number);
        printOddnumberFunctionalMethodRef(number);*/
       // printAllCourses(courses);
       // printOnlyCourseWithSpring(courses);
      //  printOnlyCourseWithNamehavingLenthAsFour(courses);
      //  printSquareOfEvenNumber(numbers);
     //   printCubesOfOddNumber(numbers);
        printNoCharInCourse(courses);
    }

    private static void printNoCharInCourse(List<String> courses) {
        courses.stream()
                .mapToInt(num -> num.length())
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2!=0)
                .map(num -> num*num*num)
                .forEach(System.out::println);
    }

    private static void printSquareOfEvenNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num%2==0)
                .map(n -> n*n)
                .forEach(System.out::println);
    }

    private static void printOnlyCourseWithNamehavingLenthAsFour(List<String> courses) {
        courses.stream()
                .filter(course -> course.length()>=4)
                .forEach(System.out::println);
    }

    private static void printOnlyCourseWithSpring(List<String> courses) {
        courses.stream()
                .filter( course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printOddnumberFunctionalMethodRef(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num%2!=0)
                .forEach(System.out::println);
    }


    private static void printAllnumberFunctional(List<Integer> integers) {
        integers.stream().forEach(num -> System.out.println(num));
    }

    private static void printAllnumberFunctionalMethodRef(List<Integer> integers) {
        integers.stream()
                .filter(num -> num%2==0)
                .forEach(System.out::println);
    }

    private static void printAllEvennumber(List<Integer> numbers) {
        for(int num:numbers){
            if(num%2==0)
            System.out.println(num);
        }
    }
}
