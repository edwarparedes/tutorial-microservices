package com.course.carservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*@Getter
@Setter*/
@Data
@Document
public class Car {
    @Id
    private String id;
    private String brand;
    private String model;
    private String userId;
}
