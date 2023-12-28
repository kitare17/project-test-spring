package com.kitare.course.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kitare.course.entiy.Course;
import com.kitare.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public MappingJacksonValue getAllCourses() {
        List<Course> courses=courseService.getAllCourses();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(courses);
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("id","courseName");
        FilterProvider filters=new SimpleFilterProvider().addFilter("courseFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
      return null;
    }

    @GetMapping("/find/{id}")
    public MappingJacksonValue getCourseById(@PathVariable Integer id) {
        Course course = courseService.findCourse(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(course);
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("id");
        FilterProvider filters=new SimpleFilterProvider().addFilter("courseFilter",filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
