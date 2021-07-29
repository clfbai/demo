package com.example.my_code.event.listener;

import com.example.my_code.event.EventT;
import lombok.Data;

@Data
public class TowEventListener implements MyEventListener {
    private String name;

    public TowEventListener(String name) {
        this.name = name;
    }

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
