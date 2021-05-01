package com.pb.laboratory.domain.po;

import lombok.Data;

import javax.persistence.*;

@Table(name = "laboratory_info")
@Data
public class LaboratoryInfo {
    private Integer id;

    @Column(name = "laboratory_name")
    private String laboratoryName;

    @Column(name = "`desc`")
    private String desc;
}