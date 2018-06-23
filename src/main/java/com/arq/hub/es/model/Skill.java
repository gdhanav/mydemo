package com.arq.hub.es.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@Table(name="skill")
//@Data
//@EqualsAndHashCode(exclude = {"employees"})
//@ToString(exclude = {"employees"})
public class Skill implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long skillId;
    @Column(name = "sname", unique = true)
    private String skillName;
    @ManyToMany(mappedBy = "skills")
    @JsonIgnoreProperties("skills")
    private Set<Employee> employeeSet = new HashSet<>();

    public Skill() {
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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return Objects.equals(getSkillName(), skill.getSkillName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSkillName());
    }
}
