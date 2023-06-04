package com.wkurkiewicz.sda_projekt_koncowy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@Builder
@RequiredArgsConstructor
public class Classes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 100)
    @Column(name = "name")
    private String name;
    private String desription;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "course_block_id")
    private CourseBlock courseBlock;
}
