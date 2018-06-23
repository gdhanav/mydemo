package com.arq.hub.es.repository;

import com.arq.hub.es.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {

    Skill findBySkillName(String skillName);
    Page<Skill> findAll(Pageable pageable);
    List<Skill> findBySkillNameContaining(String name);
}
