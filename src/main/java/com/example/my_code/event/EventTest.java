package com.example.my_code.event;

import com.example.my_code.event.listener.MyEventListener;
import com.example.my_code.event.listener.OneEventListener;
import com.example.my_code.event.listener.TowEventListener;

public class EventTest {
    public static void main(String[] args) {
        //初始化事件源
        EventManager eSource = EventManager.getInstance();
        MyEventListener one = new OneEventListener("学生");
        MyEventListener tow = new TowEventListener("老师");
        //绑定监听对象
        eSource.addListener(one);
        eSource.addListener(tow);

        //触发时间
        EventT event = new EventT(eSource, "敲铃铛");
        event.setAs(1);

        //绑定触发事件
        eSource.postEvent(event);


    }
}
