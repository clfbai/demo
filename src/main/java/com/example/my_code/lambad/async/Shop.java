package com.example.my_code.lambad.async;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Data
@NoArgsConstructor
public class Shop {
    public Shop(String goods) {
        this.goods = goods;
    }

    private String goods;

    private Random r = new Random();

    public double getPrice(String goods) {
        return 0;
    }

    public Future<Double> getAsyncPrice2(String goods) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(goods));
    }

    public Future<Double> getAsyncPrice(String goods) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            double d = calculatePrice(goods);
            future.complete(d);
        }).start();
        return future;
    }

    public double calculatePrice(String goods) {
        delay();
        return r.nextDouble() * goods.charAt(0) * goods.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("苹果");

        long start = System.currentTimeMillis();
        Future<Double> future = shop.getAsyncPrice(shop.goods);

        long end = (System.currentTimeMillis() - start) / 1000;
        System.out.println("end : " + end);
        Double a = future.get();
        System.out.println("计算价格:" + a);
        long end2 = (System.currentTimeMillis() - start) / 1000;
        System.out.println(end2);

    }

    public void listFre() {
        Shop shop = new Shop("苹果");
        List<Shop> list = Arrays.asList(shop, new Shop("小米"), new Shop("华为"));
        list.stream().map(s -> s.getAsyncPrice2(s.goods));
    }


    public void createString() {
        String s = "";
    }
}
