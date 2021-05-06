package com.pb.laboratory.domain.po;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
public class Appointment {
    @Id
    private Long id;

    @Column(name = "teacher_name")
    private String teacherName;

    private String date;

    @Column(name = "tell_number")
    private String tellNumber;

    @Column(name = "laboratory_id")
    private Integer laboratoryId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "update_time")
    private Date updateTime;

}