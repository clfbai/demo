package com.example.my_code.lambad.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private Random r = new Random();

    public double getPrice(String goods) {
        return 0;
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
}
