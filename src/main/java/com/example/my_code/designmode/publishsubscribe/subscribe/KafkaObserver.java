package com.example.my_code.designmode.publishsubscribe.subscribe;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 具体观察者类
 * @author: caolinfeng
 * @date: 2021/7/29 2:37 下午
 */
@Data
@NoArgsConstructor
public class KafkaObserver implements Observer {

    public KafkaObserver(String name) {
        this.name = name;
    }

    private String name;

    private String groupId;

    @Override
    public void update(String msg) {
        System.out.println(name+":"+msg);
    }
}
