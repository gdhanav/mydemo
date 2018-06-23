package com.arq.hub.es.controller;

import com.arq.hub.es.dto.EmployeeDto;
import com.arq.hub.es.dto.EmployeePageResultsDto;
import com.arq.hub.es.dto.EmployeeRequestDto;
import com.arq.hub.es.dto.SkillRequestDto;
import com.arq.hub.es.model.Employee;
import com.arq.hub.es.model.Skill;
import com.arq.hub.es.service.EmployeeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/es/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value="/emp/{name}")
    private EmployeeDto getEmp(@PathVariable String name)  {
            Employee employee = employeeService.getEmp(name);
        return mapper.map(employee,EmployeeDto.class);
    }
    @GetMapping(value="/emp/bySkill/wc/{name}")
    private List<EmployeeRequestDto> getEmpBySkill(@PathVariable String name)  {
        return employeeService.getEmpBySkill(name);
    }
    @PostMapping(value="/emp")
    private EmployeeRequestDto addEmp(@RequestBody EmployeeRequestDto employeeRequestDto){
        Employee employee = mapper.map(employeeRequestDto,Employee.class);
        Employee emp_created = employeeService.addEmployee(employee);
        return mapper.map(emp_created,EmployeeRequestDto.class);
    }

    @PutMapping(value="/emp")
    private EmployeeRequestDto updateEmp(@RequestBody EmployeeRequestDto employeeRequestDto){

        Employee employee = mapper.map(employeeRequestDto,Employee.class);
        Employee emp_updated = employeeService.updateEmployee(employee);
        return mapper.map(emp_updated,EmployeeRequestDto.class);
    }

    @GetMapping(value="/emp/all")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    private EmployeePageResultsDto getAllEmp(Pageable pageable)  {
        return employeeService.getAllEmployee(pageable);
    }

    @GetMapping(value="/emp/skill/{id}")
    private SkillRequestDto getSkill(@PathVariable long id){
        return mapper.map(employeeService.getSkillById(id),SkillRequestDto.class);
    }
    @GetMapping(value="/emp/skill/wc/{name}")
    private List<SkillRequestDto> getSkill(@PathVariable String name){
        return employeeService.getSkillByName(name);
    }
    @GetMapping(value="/emp/skill/all")
    private List<SkillRequestDto> getAllSkill(){
        java.lang.reflect.Type targetListType = new TypeToken<List<SkillRequestDto>>() {}.getType();
        return mapper.map(employeeService.getAllSkill(),targetListType);
    }

    @PostMapping(value="/emp/skill")
    private SkillRequestDto addEmpSkill(@RequestBody SkillRequestDto skillRequestDto){
        Skill skill = mapper.map(skillRequestDto,Skill.class);
        Skill skill1_created = employeeService.addSkill(skill);
        return mapper.map(skill1_created,SkillRequestDto.class);
    }

    @PutMapping(value="/emp/skill")
    private SkillRequestDto updateEmpSkill(@RequestBody SkillRequestDto skillRequestDto){
        Skill skill = mapper.map(skillRequestDto,Skill.class);
        Skill skill1_created = employeeService.updateSkill(skill);
        return mapper.map(skill1_created,SkillRequestDto.class);
    }

}
