package com.pb.laboratory.domain.po;

import lombok.Data;

import javax.persistence.*;

@Table(name = "class_info")
@Data
public class ClassInfo {
    private Integer id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "`desc`")
    private String desc;
}