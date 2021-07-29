package com.example.my_code.designmode;

import com.example.my_code.designmode.publishsubscribe.subscribe.KafkaObserver;
import com.example.my_code.designmode.publishsubscribe.topic.Subject;
import com.example.my_code.designmode.publishsubscribe.topic.SubscriptionSubject;

public class DesignTest {
    public static void main(String[] args) {
        Subject subject = new SubscriptionSubject();
        KafkaObserver one = new KafkaObserver("1号消费者");
        KafkaObserver tow = new KafkaObserver("2号消费者");
        subject.addObserver(one);
        subject.addObserver(tow);
        subject.publish("老弟来消费");

    }
}
