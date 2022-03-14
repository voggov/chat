package com.coderiders.happyanimal.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    private Long id;
    private String name;
    private String gender;
    private int age;
    private int height;
    private double weight;
    private String animalClass;
    private String squad;
    private String kind;
    private String location;
    private String status;
}
