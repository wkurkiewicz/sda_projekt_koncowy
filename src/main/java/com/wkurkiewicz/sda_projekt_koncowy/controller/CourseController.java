package com.wkurkiewicz.sda_projekt_koncowy.controller;

import com.wkurkiewicz.sda_projekt_koncowy.dto.CourseDto;
import com.wkurkiewicz.sda_projekt_koncowy.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public String couses(Model model){
        List<CourseDto> coursesFromDB = courseService.getCourses();
        model.addAttribute("courses", coursesFromDB);
        return "courses";
    }

}
