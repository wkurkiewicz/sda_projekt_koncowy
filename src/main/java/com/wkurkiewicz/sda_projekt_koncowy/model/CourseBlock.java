package com.wkurkiewicz.sda_projekt_koncowy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
@Builder
@RequiredArgsConstructor
public class CourseBlock {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "courseBlock")
    private List<Classes> classes;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
