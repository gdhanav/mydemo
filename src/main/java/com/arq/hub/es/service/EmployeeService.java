package com.arq.hub.es.service;

import com.arq.hub.es.dto.EmployeeDto;
import com.arq.hub.es.dto.EmployeePageResultsDto;
import com.arq.hub.es.dto.EmployeeRequestDto;
import com.arq.hub.es.dto.SkillRequestDto;
import com.arq.hub.es.exception.EmployeeNotFound;
import com.arq.hub.es.exception.EmployeeServiceException;
import com.arq.hub.es.model.Employee;
import com.arq.hub.es.model.Skill;
import com.arq.hub.es.repository.EmployeeRepository;
import com.arq.hub.es.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository=employeeRepository;
    }

    public Employee getEmp(String name) throws EmployeeNotFound {
        Employee employee=null;
        try {
           employee= employeeRepository.findByName(name);
           if(employee==null){
               throw new EmployeeNotFound();
           }
       }catch(EmployeeNotFound ex){
           throw new EmployeeNotFound("Employee not found");
       }
       return employee;
   }

   public List<EmployeeRequestDto> getEmpBySkill(String name) throws EmployeeServiceException{
        try{
            java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeRequestDto>>() {}.getType();
            return mapper.map(employeeRepository.findBySkillsSkillNameContaining("%"+name+"%"),targetListType);
        }catch (EmployeeServiceException ex){
            throw new EmployeeServiceException("getEmpBySkill() --> Error on EmpBySkill search"+ex);
        }
   }

   public Employee addEmployee(Employee employee) throws EmployeeServiceException{
        try{
//

                for(Skill skill: employee.getSkills()){
                    Skill skill_saved = skillRepository.findBySkillName(skill.getSkillName());
                        if(skill_saved==null) {
//                            Skill sSkill = new Skill(skill.getSkillId(),skill.getSkillName());
//                            skillRepository.save(skill);
                            skill=skillRepository.save(skill);
                            employee.getSkills().add(skill);

                        }

//                        else {
//                            skill.setSkillId(skill_saved.getSkillId());
//                        }
                }

           return employeeRepository.save(employee);
        }catch (Exception ex){
            throw new EmployeeServiceException("addEmployee() --> Error on Insert "+ex);
        }
   }

    public Employee updateEmployee(Employee employee) throws EmployeeServiceException{
        try{

            for(Skill skill: employee.getSkills()){
                Skill skill_saved = skillRepository.findBySkillName(skill.getSkillName());
                if(skill_saved==null) {
//                            Skill sSkill = new Skill(skill.getSkillId(),skill.getSkillName());
                    skill=skillRepository.save(skill);
                    employee.getSkills().add(skill);

                }
//                else {
//                            skill.setSkillId(skill_saved.getSkillId());
//                }
            }
            return employeeRepository.save(employee);
        }catch (Exception ex){
            throw new EmployeeServiceException("updateEmployee() --> Error on Update "+ex);
        }
    }

    public EmployeePageResultsDto getAllEmployee(Pageable pageable) throws EmployeeServiceException{
        try{
            java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeRequestDto>>() {}.getType();
            Page<Employee> employee = employeeRepository.findAll(pageable);
            EmployeePageResultsDto dto = new EmployeePageResultsDto();
            List<EmployeeRequestDto> emps = mapper.map(employee.getContent(),targetListType);
            dto.setEmps(emps);
            dto.setOffset(employee.getPageable().getOffset());
            dto.setCurrentPage(employee.getPageable().getPageNumber());
            dto.setFirst(employee.isFirst());
            dto.setLast(employee.isLast());
            dto.setTotalPages(employee.getTotalPages());
            dto.setPageSize(employee.getPageable().getPageSize());
            dto.setTotalElements(employee.getTotalElements());
            return dto;
        }catch (Exception ex){
            throw new EmployeeServiceException("updateEmployee() --> Error on Update "+ex);
        }
    }

    public Skill addSkill(Skill skill) throws EmployeeServiceException{
        try{
            return skillRepository.save(skill);
        }catch (Exception ex){
            throw new EmployeeServiceException("addSkill() --> Error on Insert "+ex);
        }
    }

    public Skill updateSkill(Skill skill) throws EmployeeServiceException{
        try{

            return skillRepository.save(skill);
        }catch (Exception ex){
            throw new EmployeeServiceException("updateSkill() --> Error on Insert "+ex);
        }
    }

    public Skill getSkillById(long id) throws EmployeeServiceException{
        try{
            Optional<Skill> skill= skillRepository.findById(id);
            skill.orElseThrow(()-> new EmployeeServiceException("Skill Not Found"));
            return skill.get();
        }catch (Exception ex){
            throw new EmployeeServiceException("getSkillByName() --> Error on fetch by skill name "+ex);
        }
    }

    public List<Skill> getAllSkill() throws EmployeeServiceException{
        try{
            return skillRepository.findAll();
        }catch (Exception ex){
            throw new EmployeeServiceException("getAllSkill() --> Error on fetch by All skill "+ex);
        }
    }

    public List<SkillRequestDto> getSkillByName(String name) throws EmployeeServiceException{
        try{
            java.lang.reflect.Type targetListType = new TypeToken<List<SkillRequestDto>>() {}.getType();
            List<Skill> skills = skillRepository.findBySkillNameContaining("%"+name+"%");
            return mapper.map(skills,targetListType);
        }catch (Exception ex){
            throw new EmployeeServiceException("getSkillByName() --> Error on fetch skill by name "+ex);
        }
    }
}
