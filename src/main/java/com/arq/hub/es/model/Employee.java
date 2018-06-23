package com.arq.hub.es.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
//@Table(name="employee")
//@Getter
//@Setter
//@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"skills"})
public class Employee implements Serializable {

    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private long eId;

    public Employee() {
    }

    @ManyToMany
    @JoinTable(name = "emp_skill",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @JsonIgnoreProperties("employees")
    private Set<Skill> skills = new HashSet<>();

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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName());
    }
}