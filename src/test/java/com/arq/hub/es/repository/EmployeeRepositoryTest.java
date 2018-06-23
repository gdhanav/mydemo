package com.arq.hub.es.repository;

import com.arq.hub.es.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private  EmployeeRepository employeeRepository;
    /**
     * TestEntityManager will take care of server cache
     * and flush it to the database
     */
    @Autowired
    private TestEntityManager entityManager;


//    @Test
//    public void getEmployee_returnEmployeeDetails() throws Exception{
//        Employee emp = entityManager.persistFlushFind(new Employee(1,"sam"));
//        Employee employee = employeeRepository.findByName("sam");
//
////        assertThat(employee.getName()).isEqualTo(emp.getName());
//    }


}
