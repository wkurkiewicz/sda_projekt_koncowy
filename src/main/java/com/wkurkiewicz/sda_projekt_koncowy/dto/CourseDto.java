package com.wkurkiewicz.sda_projekt_koncowy.dto;

import com.wkurkiewicz.sda_projekt_koncowy.model.Course;
import com.wkurkiewicz.sda_projekt_koncowy.model.CourseBlock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Integer id;
    private String name;
    private String imageName;
    private List<CourseBlock> courseBlocks;
    private String description;
}
