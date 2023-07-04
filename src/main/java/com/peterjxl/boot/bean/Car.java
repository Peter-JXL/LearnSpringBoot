package com.peterjxl.boot.bean;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mycar")
@Data
@ToString
public class Car {
    private String brand;
    private Integer price;
}
