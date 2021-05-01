package com.pb.laboratory.domain.dto.response;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
* TODO description
*
* @author fukua
* @date 2021/05/01
* @since 1.0
*/
@Data
public class CourseRespDTO implements Serializable {

    private static final long serialVersionUID = -5645360668096923003L;

    private Integer id;

    private String courseName;

    private String courseTime;

    private String desc;

}
