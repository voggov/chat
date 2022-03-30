package com.coderiders.happyanimal.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Kind")
public class AnimalKind {

    @Id
    @Column(name = "kind")
    private String kind;

    @Column(name = "class")
    private String animalClass;

    @Column(name = "squad")
    private String squad;


    @Column(name = "pic")
    private byte[] pic;
}
