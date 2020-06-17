package com.rakesh.learn.functionalprograming;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
 private String name;
 private String category;
 private int reviewScrore;
 private  int noOfstudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScrore = reviewScore;
        this.noOfstudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScrore() {
        return reviewScrore;
    }

    public void setReviewScrore(int reviewScrore) {
        this.reviewScrore = reviewScrore;
    }

    public int getNoOfstudents() {
        return noOfstudents;
    }

    public void setNoOfstudents(int noOfstudents) {
        this.noOfstudents = noOfstudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScrore=" + reviewScrore +
                ", noOfstudents=" + noOfstudents +
                '}';
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {


        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));


        Predicate<Course> coursePredicateGreterThan95 = course -> course.getReviewScrore()>95;

        Predicate<Course> coursePredicateGreterThan90 = course -> course.getReviewScrore()>90;

        Predicate<Course> coursePredicateLessThan90 = course -> course.getReviewScrore()<90;

        //AllMatch nonematch
        System.out.println(courses.stream().allMatch( coursePredicateGreterThan95));
        System.out.println(courses.stream().noneMatch(coursePredicateLessThan90));
        System.out.println(courses.stream().anyMatch(coursePredicateGreterThan90));
        System.out.println(courses.stream().anyMatch(coursePredicateGreterThan95));



        Comparator<Course> comparingByNoOfStudentsIncreasing= Comparator.comparing(Course ::getNoOfstudents);

        Comparator<Course> comparingByNoOfStudentsDecreasing= Comparator.comparing(Course ::getNoOfstudents).reversed();

        Comparator<Course> comparingByNoOfStudentsAndReview =
                Comparator.comparing(Course ::getNoOfstudents)
                        .thenComparing(Course::getReviewScrore)
                           .reversed();


        /*System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsIncreasing)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndReview)
                .collect(Collectors.toList()));*/

        //limit
       /* System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndReview)
                .limit(5)
                .collect(Collectors.toList()));*/
        //skip
        /*System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndReview)
                .skip(3)
                .collect(Collectors.toList()));*/

        //skip and limit
       /* System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndReview)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList()));*/

        //takeaway
        /*System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScrore()>=95)
                .collect(Collectors.toList()));*/

        //dropWhile
        /*System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScrore()>=95)
                .collect(Collectors.toList()));*/

        Optional<Course> c1 = courses.stream()
                .max(Comparator.comparing(Course::getNoOfstudents));

        System.out.println(c1.get());

        Optional<Course> c2 = courses.stream()
                .min(Comparator.comparing(Course::getNoOfstudents));

        System.out.println(c2.get());

       int totalSum = courses.stream()
                .filter(coursePredicateGreterThan95)
                .mapToInt(Course::getNoOfstudents)
                .sum();

        System.out.println(totalSum);

        OptionalDouble aveargeStu = courses.stream()
                .filter(coursePredicateGreterThan95)
                .mapToInt(Course::getNoOfstudents)
                .average();

        System.out.println(aveargeStu);

        courses.stream()
                 .collect(Collectors.groupingBy(Course::getCategory));

        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory));


    }
}
