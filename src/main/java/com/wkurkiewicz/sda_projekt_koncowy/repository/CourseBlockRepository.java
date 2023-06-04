package com.wkurkiewicz.sda_projekt_koncowy.repository;
import com.wkurkiewicz.sda_projekt_koncowy.model.CourseBlock;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseBlockRepository extends JpaRepository<CourseBlock, Integer>{
    List<CourseBlock> findCourseBlocksByCourseId(Integer courseId);
}
