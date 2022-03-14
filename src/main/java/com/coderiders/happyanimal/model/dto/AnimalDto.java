package com.coderiders.happyanimal.model.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String gender;
    @NotNull
    private int age;
    @NotNull
    private int height;
    @NotNull
    private double weight;
    @NotNull
    private String animalClass;
    @NotNull
    private String squad;
    @NotNull
    private String kind;
    @NotNull
    private String location;
    @NotNull
    private String status;
}
