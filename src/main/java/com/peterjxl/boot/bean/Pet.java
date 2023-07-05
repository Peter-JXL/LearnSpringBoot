package com.peterjxl.boot.bean;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
    private String name;
    private Double weight;
}
