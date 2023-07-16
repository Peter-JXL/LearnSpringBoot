package com.peterjxl.boot.bean;
import lombok.Data;
import java.util.Date;

@Data
public class Person2 {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet2 pet;
}
