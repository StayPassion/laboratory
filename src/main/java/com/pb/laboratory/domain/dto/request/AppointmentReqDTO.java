package com.pb.laboratory.domain.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * TODO description
 *
 * @author fukua
 * @date 2021/05/01
 * @since 1.0
 */
@Data
public class AppointmentReqDTO implements Serializable {

    private static final long serialVersionUID = -1399106088578892798L;

    @NotNull
    @Length(max = 5,min = 1,message = "老师姓名不能为空")
    private String teacherName;

    @NotNull
    @NotBlank(message = "日期不能为空")
    private String date;

    @NotBlank(message = "电话不能为空")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$",message="请输入正确的手机号码")
    private String tellNumber;

    @NotNull
    private Integer laboratoryId;

    private Integer courseId;

    private Integer classId;

    @NotNull
    @NotBlank(message = "班级不能为空")
    private String className;

}
