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
public class ClassInfoRespDTO implements Serializable {

    private static final long serialVersionUID = -477099425870801846L;

    private Integer id;

    private String className;

    private String desc;
}
