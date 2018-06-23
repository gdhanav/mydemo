package com.arq.hub.es.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class SkillDto {

//    @JsonIgnore
    private long skillId;
    private String skillName;
//    @JsonIgnore
    private Set<EmployeeDto> employeeDtos = new HashSet<>();

    public SkillDto() {
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Set<EmployeeDto> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(Set<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }
}
