package com.coderiders.happyanimal.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("Мужской"),
    FEMALE("Женский"),
    NONE("");

    final String TITLE;
}
