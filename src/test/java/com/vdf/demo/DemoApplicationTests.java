package com.vdf.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = DemoApplication.class)
@AutoConfigureMockMvc
public class DemoApplicationTests {

    //    curl -X POST http://localhost:8080/api/employees -d '{"firstName": "Test1"}' -H 'Content-Type: application/json' -v

    @Autowired
    private MockMvc mvc;

    @Before
    public void createEmployee() throws Exception {

        mvc.perform(post("/employees")
            .content("{\"firstName\": \"Test1\"}")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.firstName").value("Test1"));
    }

    @Test
    public void testEMployeesByID() throws Exception {
        mvc.perform(get("/employees/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testEmployees() throws Exception {

        mvc.perform(get("/employees")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    public void contextLoads() {
    }
}
