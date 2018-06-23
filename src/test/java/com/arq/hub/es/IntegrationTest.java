package com.arq.hub.es;

import com.arq.hub.es.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;



    @Test
    public void getEmployeeTest(){
        //act

        //arrange
        ResponseEntity<Employee> response = restTemplate.getForEntity("/es/api/emp/sam",Employee.class);
        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getBody().getName()).isEqualTo("sam");
//        assertThat(response.getBody().getId()).isEqualTo("1");
    }

}
