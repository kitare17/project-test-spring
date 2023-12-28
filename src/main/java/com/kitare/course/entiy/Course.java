package com.kitare.course.entiy;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "course")
@JsonFilter("courseFilter")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_price", precision = 18, scale = 2)
    private BigDecimal coursePrice;



}