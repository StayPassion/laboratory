package com.pb.laboratory.domain.po;

import javax.persistence.*;

@Table(name = "laboratory_info")
public class LaboratoryInfo {
    private Integer id;

    @Column(name = "laboratory_name")
    private String laboratoryName;

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
     * @return laboratory_name
     */
    public String getLaboratoryName() {
        return laboratoryName;
    }

    /**
     * @param laboratoryName
     */
    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
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