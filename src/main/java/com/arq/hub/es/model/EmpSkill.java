package com.arq.hub.es.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//@Entity
///@Table(name="emp_skill")
public class EmpSkill implements Serializable {

    @Id
    @GeneratedValue
    private long empSkillId;

    @Column(name="skillID")
    private long skillId;

    @Column(name="SkillName")
    private String SkillName;

    public long getEmpSkillId() {
        return empSkillId;
    }

    public void setEmpSkillId(long empSkillId) {
        this.empSkillId = empSkillId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }
}
