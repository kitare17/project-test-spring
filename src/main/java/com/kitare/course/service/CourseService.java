package com.kitare.course.service;

import com.kitare.course.entiy.Course;
import com.kitare.course.respository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course findCourse(int id){
        return courseRepository.findById(id).orElse(null);
    }
}
