package com.wkurkiewicz.sda_projekt_koncowy.repository;
import com.wkurkiewicz.sda_projekt_koncowy.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<Course, Integer>{
}
