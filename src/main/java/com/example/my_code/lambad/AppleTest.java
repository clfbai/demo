package com.example.my_code.lambad;

import com.example.my_code.pojo.Apple;

import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppleTest {

    public static List<Apple> filterApples(List<Apple> apples, Filter<Apple> appleFilter) {
        return apples.stream().filter(appleFilter::appleCompare).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Apple apple = new Apple("read", 22.5, 1);
        Apple apple2 = new Apple("green", 42.5, 1);
        List<Apple> var = Arrays.asList(apple, apple2);
        var.parallelStream().sorted(Comparator.comparing(Apple::getWeight)).map(Apple::getColour).limit(2).collect(Collectors.toList());
        var.parallelStream().mapToDouble(Apple::getWeight).sum();
        var.sort(Comparator.comparing(Apple::getWeight));
        //方法传递
        List<Apple> apples_1 = filterApples(var, Apple::filterWeight);
        //类型推导方法传递
        List<Apple> apples_2 = filterApples(var, (Apple t) -> t.getColour().equals("read"));
        //平方根
        double at = Math.sqrt(3 * 3 + 4 * 4) % 1;
        boolean x = at == 0;
        System.out.println(at);
        System.out.println(x);
        System.out.println("a1: " + apples_1);
        System.out.println("a2: " + apples_2);
        //斐波那契元祖序列
        Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(10)
                .map(s -> s[0])
                .forEach(s -> System.out.println(s));


        List<Integer> listNum = Arrays.asList(125, 1, 0, 2, 3, 45, 6, 78, 123123, 123);
        testOne(listNum);
    }


    public static void testOne(List<Integer> listNum) {
        System.out.println("++++++>>>>>>>>>>>++++++>>>>>>>>>>>");
        System.out.println("++++++>>>>>>>>>>>++++++>>>>>>>>>>>");
        //过滤出 > 122 的数 取第一个 如果没有 获得 0   .orElse(0)
        Integer t1 = listNum.stream().filter(s -> s > 122).findFirst().orElse(0);
        //过滤出 > 122 的数 去任意一个 如果没有 获得 0   .orElse(0)
        Integer t = listNum.stream().filter(s -> s > 12222).findAny().orElse(0);
        //判断是否任意一个数为 123
        boolean atWill = listNum.stream().anyMatch(s -> s.equals(123));
        //判断所有数 >0
        boolean atAll = listNum.stream().allMatch(s -> s > 0);
        System.out.println(t1);
        System.out.println(t);
        System.out.println(atWill);
        System.out.println(atAll);
    }

    public void cer() {
        Subject subject = new Subject();
    }
}
