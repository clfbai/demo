package com.example.my_code.lambad;

import com.example.my_code.pojo.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppleTest {

    public static List<Apple> filterApples(List<Apple> apples, Filter<Apple> appleFilter) {
        return apples.stream().filter(appleFilter::appleCompare).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Apple apple = new Apple("read", 22.5, 1);
        Apple apple2 = new Apple("green", 42.5, 1);
        List<Apple> var = Arrays.asList(apple, apple2);
        var.parallelStream().sorted(Comparator.comparing(Apple::getWeight)).map(Apple::getColour).limit(2).collect(Collectors.toList());
        var.sort(Comparator.comparing(Apple::getWeight));
        //方法传递
        List<Apple> a = filterApples(var, Apple::filterWeight);
        //类型推导方法传递
        List<Apple> a1 = filterApples(var, (Apple t) -> t.getColour().equals("read"));
        System.out.println("a: " + a);
        System.out.println("a1: " + a1);
    }
}
