package com.arq.hub.es.service;

import com.arq.hub.es.exception.EmployeeNotFound;
import com.arq.hub.es.model.Employee;
import com.arq.hub.es.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

//    @Before
//    public void setup() throws Exception{
//        employeeService = new EmployeeService(employeeRepository);
//    }
//
//    @Test
//    public void getEmpDetails_returnEmpInfo(){
//        given(employeeRepository.findByName("sam")).willReturn(new Employee(1,"sam"));
//
//        Employee employee = employeeService.getEmp("sam");
//
////        Assertions.assertThat(employee.getId()).isEqualTo(new Long(1));
////        Assertions.assertThat(employee.getName()).isEqualTo("sam");
//
//    }
//    @Test(expected = EmployeeNotFound.class)
//    public void getEmpDetails_whenEmpNotFound() throws Exception{
//        given(employeeRepository.findByName("sam")).willReturn(null);
//        employeeService.getEmp("sam");
//    }
}
