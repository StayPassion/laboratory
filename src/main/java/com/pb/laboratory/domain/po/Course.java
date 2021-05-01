package com.pb.laboratory.domain.po;

import javax.persistence.*;

public class Course {
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_time")
    private String courseTime;

    private String desc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return course_name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return course_time
     */
    public String getCourseTime() {
        return courseTime;
    }

    /**
     * @param courseTime
     */
    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    /**
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}