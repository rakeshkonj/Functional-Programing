package com.rakesh.learn.functionalprograming;

import com.sun.source.tree.BreakTree;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FB04FunctionalInterfaces {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Supplier<Integer> randoam = () -> {
            Random random = new Random();
             return random.nextInt(1000);
        };

       // System.out.println(randoam.get());

        UnaryOperator<Integer> unOp = (x) -> x*3;
      //  System.out.println(unOp.apply(4));

        BiPredicate<Integer,String > biPredicate = (number,str) -> {

           return number>10 && str.length()>5;
        };

     //   System.out.println(biPredicate.test(15,"Rakesh"));

        BiFunction<Integer,String,String > biFunction = (number,str) -> {
                return number + " " + str;
        };
     //   System.out.println(biFunction.apply(10,"rakesh"));

        BiConsumer<Integer,String > biConsumer = (n,s2) -> {
            System.out.println(n);
            System.out.println(s2);
        };

        biConsumer.accept(10,"tests");
    }
}
