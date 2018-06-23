package com.arq.hub.es.dto;

import com.arq.hub.es.dto.Impl.DTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EmployeeRequestDto extends DTO {

    private String name;

    private long eId;

    private Set<SkillRequestDto> skills = new HashSet<SkillRequestDto>();

    public EmployeeRequestDto() {
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

    public Set<SkillRequestDto> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillRequestDto> skills) {
        this.skills = skills;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeRequestDto)) return false;
        EmployeeRequestDto that = (EmployeeRequestDto) o;
        return geteId() == that.geteId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSkills(), that.getSkills());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), geteId(), getSkills());
    }
}
