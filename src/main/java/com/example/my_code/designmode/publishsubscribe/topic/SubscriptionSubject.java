package com.example.my_code.designmode.publishsubscribe.topic;

import com.example.my_code.designmode.publishsubscribe.subscribe.Observer;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 被观察者
 * @author: caolinfeng
 * @date: 2021/7/29 2:38 下午
 */
public class SubscriptionSubject implements Subject {
    private List<Observer> list = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (CollectionUtils.isEmpty(list)) return;
        list.remove(observer);
    }

    @Override
    public void publish(String msg) {
        if (CollectionUtils.isEmpty(list)) return;
        list.forEach(s -> s.update(msg));
    }
}
