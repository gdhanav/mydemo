package com.arq.hub.es.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SkillRepositoryTest {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TestEntityManager entityManager;

//    @Test
//    public void getSkill_returnEmployeeSkills() throws Exception{
//        Skill save_skill = entityManager.persistFlushFind(new Skill(1,"java"));
//        Skill skill  = skillRepository.findBySkillName("java");
//
////        assertThat(employee.getName()).isEqualTo(emp.getName());
//    }
}
