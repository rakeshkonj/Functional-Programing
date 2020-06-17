package com.rakesh.learn.functionalprograming;

import java.util.List;
import java.util.function.Supplier;

public class FB05MethodReferences {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

    courses.stream()
           //.map(str -> str.toUpperCase())
            .map(String::toUpperCase)
            .forEach(System.out::println);


        Supplier<String> supplier = () -> new String();
        //else
        Supplier<String> supplier1 = String::new;

    }
}
