package com.arq.hub.es.repository;

import com.arq.hub.es.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

    Employee findByName(String name);
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findBySkillsSkillNameContaining(String name);

}
