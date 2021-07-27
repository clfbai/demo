package com.example.my_code.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Apple implements Serializable {
    public Apple(String colour, Double weight, Integer type) {
        this.colour = colour;
        this.weight = weight;
        this.type = type;
    }

    private Long id;

    private String colour;

    private Double weight;

    private Integer type;

   public static boolean filterWeight(Apple a){
       return a.getWeight()>30;
   }
}
