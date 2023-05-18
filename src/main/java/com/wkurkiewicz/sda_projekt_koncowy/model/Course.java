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
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
//    @OneToMany(mappedBy = "course")
//    private List<CourseBlock> courseBlocks;
}
