package com.arq.hub.es.controller;

import com.arq.hub.es.exception.EmployeeNotFound;
import com.arq.hub.es.model.Employee;
import com.arq.hub.es.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

//    @Test
//    public void getEmployee_ShouldReturnEmployee() throws Exception{
//        given(employeeService.getEmp(anyString())).willReturn(new Employee(1,"sam"));
//        mockMvc.perform(MockMvcRequestBuilders.get("/es/api/emp/sam"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("name").value("sam"))
//                .andExpect(jsonPath("id").value("1"));
//
//    }
//    @Test
//    public  void getEmployee_NotFound() throws Exception{
//        given(employeeService.getEmp(anyString())).willThrow(new EmployeeNotFound());
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/es/api/emp/sam"))
//                .andExpect(status().isNotFound());
//    }
}
