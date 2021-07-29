package com.example.my_code.designmode.publishsubscribe.topic;

import com.example.my_code.designmode.publishsubscribe.subscribe.Observer;

/**
 * @description: 抽象被观察者
 * @author: caolinfeng
 * @date: 2021/7/29 1:55 下午
 */
public interface Subject {

    /**
     * @param observer
     * @return
     * @author: caolinfeng
     * @date: 2021/7/29 2:19 下午
     * @description: 添加观察者
     */
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    /**
     * @param msg 消息内容
     * @return void
     * @author: caolinfeng
     * @date: 2021/7/29 2:21 下午
     * @description: 发布消息
     */
    void publish(String msg);
}
