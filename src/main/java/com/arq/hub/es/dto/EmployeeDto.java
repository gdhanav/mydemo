package com.arq.hub.es.dto;


import com.arq.hub.es.dto.Impl.DTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EmployeeDto extends DTO {

    private String name;

    private long eId;

    private Set<SkillDto> skills = new HashSet<SkillDto>();


    public EmployeeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long geteId() {
        return eId;
    }

    public void seteId(long eId) {
        this.eId = eId;
    }

    public Set<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDto> skills) {
        this.skills = skills;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDto)) return false;
        if (!super.equals(o)) return false;
        EmployeeDto that = (EmployeeDto) o;
        return geteId() == that.geteId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getName(), geteId());
    }
}
