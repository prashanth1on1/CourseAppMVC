package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.app.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
