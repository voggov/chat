package com.coderiders.happyanimal.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "state")
    private String state;

    @Column(name = "repeat_type")
    private String repeatType;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
