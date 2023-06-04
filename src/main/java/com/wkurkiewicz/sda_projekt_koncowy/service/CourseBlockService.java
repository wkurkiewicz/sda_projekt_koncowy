package com.wkurkiewicz.sda_projekt_koncowy.service;

import com.wkurkiewicz.sda_projekt_koncowy.dto.CourseBlockDto;
import com.wkurkiewicz.sda_projekt_koncowy.dto.CourseDto;
import com.wkurkiewicz.sda_projekt_koncowy.repository.CourseBlockRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseBlockService {
    private final CourseBlockRepository courseBlockRepository;
    public List<CourseBlockDto> getCourseBlocks() {
        return courseBlockRepository.findAll().stream().map(cb -> new CourseBlockDto(cb.getId(), cb.getName(), cb.getDescription(), cb.getClasses(), cb.getCourse(), cb.getImageName())).toList();
    }
    public List<CourseBlockDto> getCourseBlocksByCourseId(Integer courseId){
        //return courseBlockRepository.findAll().stream().filter(cb ->cb.getCourse().getId().equals(courseId)).map(cb -> new CourseBlockDto(cb.getId(), cb.getName(), cb.getDescription(), cb.getClasses(), cb.getCourse(), cb.getImageName())).toList();
        return courseBlockRepository.findCourseBlocksByCourseId(courseId).stream().map(cb -> new CourseBlockDto(cb.getId(), cb.getName(), cb.getDescription(), cb.getClasses(), null, cb.getImageName())).toList();
    }
}
