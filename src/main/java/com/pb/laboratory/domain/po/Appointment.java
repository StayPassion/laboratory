package com.pb.laboratory.domain.po;

import java.util.Date;
import javax.persistence.*;

public class Appointment {
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

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return teacher_name
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return tell_number
     */
    public String getTellNumber() {
        return tellNumber;
    }

    /**
     * @param tellNumber
     */
    public void setTellNumber(String tellNumber) {
        this.tellNumber = tellNumber;
    }

    /**
     * @return laboratory_id
     */
    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    /**
     * @param laboratoryId
     */
    public void setLaboratoryId(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    /**
     * @return course_id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * @return class_id
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * @return class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}