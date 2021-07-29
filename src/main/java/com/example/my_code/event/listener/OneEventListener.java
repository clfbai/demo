package com.example.my_code.event.listener;

import com.example.my_code.event.EventT;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 具体监听器
 * @author: caolinfeng
 * @date: 2021/7/29 3:11 下午
 */
@Data
@NoArgsConstructor
public class OneEventListener implements MyEventListener {
    public OneEventListener(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void onChange(EventT t) {
        if (1 == t.getAs()) {
            System.out.println(name + "：第1种事件做: 上课玲--》 上课逻辑");
        }
        if (2 == t.getAs()) {
            System.out.println(name + "：第2种事件做: 下课课玲--》 下课逻辑");
        }
    }
}
