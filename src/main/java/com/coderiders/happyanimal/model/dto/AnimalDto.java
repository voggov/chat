package com.coderiders.happyanimal.model.dto;

import com.sun.istack.NotNull;
import lombok.*;

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
