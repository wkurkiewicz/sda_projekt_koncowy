package com.wkurkiewicz.sda_projekt_koncowy.service;

import com.wkurkiewicz.sda_projekt_koncowy.dto.CourseDto;
import com.wkurkiewicz.sda_projekt_koncowy.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<CourseDto> getCourses() {
        return courseRepository.findAll().stream().map(c -> new CourseDto(c.getId(),c.getName(), c.getImageName(), c.getCourseBlocks(), c.getDescription())).toList();
    }
}
