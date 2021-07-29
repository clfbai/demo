package com.example.my_code.event;


import java.util.EventObject;

/**
 * @description 具体事件类
 * @author: caolinfeng
 * @date: 2021/7/29 2:58 下午
 */
public class EventT extends EventObject {

    private String name;

    private Integer as;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventT(Object source, String name) {
        super(source);
        this.name = name;
    }

    public Integer getAs() {
        return as;
    }

    public void setAs(Integer as) {
        this.as = as;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
