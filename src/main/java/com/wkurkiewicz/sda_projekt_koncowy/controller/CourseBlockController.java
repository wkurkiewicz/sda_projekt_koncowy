package com.wkurkiewicz.sda_projekt_koncowy.controller;

import com.wkurkiewicz.sda_projekt_koncowy.dto.CourseBlockDto;
import com.wkurkiewicz.sda_projekt_koncowy.service.CourseBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courseblocks")
@RequiredArgsConstructor
@Slf4j
public class CourseBlockController {

    private final CourseBlockService courseBlockService;


    @GetMapping
    public String courseBlocks(Model model){
        List<CourseBlockDto> courseBlocksFromDb = courseBlockService.getCourseBlocks();
        model.addAttribute("courseBlocks", courseBlocksFromDb);
        return  "course-blocks";
    }

    @GetMapping
    @RequestMapping("/{courseId}")
    public String courseBlocksByCourseId(Model model, @PathVariable Integer courseId){
        List<CourseBlockDto> courseBlocksFromDb = courseBlockService.getCourseBlocksByCourseId(courseId);
        log.info(String.valueOf(courseId));
        model.addAttribute("courseBlocksByCourseId", courseBlocksFromDb);
        return  "course-blocks";
    }
}
