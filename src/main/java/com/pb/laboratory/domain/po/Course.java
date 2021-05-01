package com.pb.laboratory.domain.po;

import lombok.Data;

import javax.persistence.*;

@Data
public class Course {
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_time")
    private String courseTime;

    @Column(name = "`desc`")
    private String desc;
}