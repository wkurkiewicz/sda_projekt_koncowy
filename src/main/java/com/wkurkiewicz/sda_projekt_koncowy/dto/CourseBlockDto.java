package com.wkurkiewicz.sda_projekt_koncowy.dto;

import com.wkurkiewicz.sda_projekt_koncowy.model.Classes;
import com.wkurkiewicz.sda_projekt_koncowy.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseBlockDto {
    private Integer id;
    private String name;
    private String description;
    private List<Classes> classes;
    private Course course;
    private String imageName;
}
