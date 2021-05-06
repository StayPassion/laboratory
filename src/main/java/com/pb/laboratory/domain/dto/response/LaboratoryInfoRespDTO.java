package com.pb.laboratory.domain.dto.response;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO description
 *
 * @author fukua
 * @date 2021/05/01
 * @since 1.0
 */
@Data
public class LaboratoryInfoRespDTO implements Serializable {

    private static final long serialVersionUID = 4873048511722020849L;

    private Integer id;

    private String laboratoryName;

    private String desc;
}
