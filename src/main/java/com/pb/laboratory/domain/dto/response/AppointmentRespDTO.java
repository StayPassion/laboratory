package com.pb.laboratory.domain.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* TODO description
*
* @author fukua
* @date 2021/05/01
* @since 1.0
*/
@Data
public class AppointmentRespDTO implements Serializable {
    private Long id;

    private String teacherName;

    private String date;

    private String tellNumber;

    private Integer laboratoryId;

    private String laboratoryName;

    private Integer courseId;

    private String courseName;

    private String courseTime;

    private Integer classId;

    private String className;

    private Date updateTime;

}
