package com.example.my_code.event;

import com.example.my_code.event.listener.MyEventListener;

import java.util.HashSet;

/**
 * @description: 事件源
 * @author: caolinfeng
 * @date: 2021/7/29 3:11 下午
 */
public class EventManager {

    private EventManager() {

    }

    private static class single {
        private static final EventManager sessionInterceptor = new EventManager();
    }

    public static EventManager getInstance() {
        return EventManager.single.sessionInterceptor;
    }

    private HashSet<MyEventListener> listener = new HashSet<>(); //存储监听对象


    //添加事件
    public void addListener(MyEventListener e) {
        if (listener == null)
            return;
        listener.add(e);
    }

    public void postEvent(EventT event) { //触发事件的方法
        if (listener == null) {
            return;
        }
        notifyListeners(event);

    }

    private void notifyListeners(EventT event) {   //通知各自的监听方法去实现
        if (listener == null)
            return;
        for (MyEventListener eventListener : listener) {
            eventListener.onChange(event);
        }
    }

}
