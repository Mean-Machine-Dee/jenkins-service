package com.meanmachine.tutorial.controller;

import com.meanmachine.tutorial.entity.Department;
import com.meanmachine.tutorial.errors.DepartmentNotFoundException;
import com.meanmachine.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private DepartmentService departmentService;


    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .depertmentName("Accounts")
                .code("ACCS")
                .address("Nairobi")
                .depertmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
       Department input = Department.builder()
                .depertmentName("Accounts")
                .code("ACCS")
                .address("Nairobi")
                .build();

        Mockito.when(departmentService.saveDeparment(input)).thenReturn(
                department
        );
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"depertmentName\":\"Accounts\",\n" +
                        "\t\"address\":\"Nairobi\",\n" +
                        "\t\"code\":\"ACCS\"\n" +
                        "}"))
                .andExpect(status().isCreated());
    }

    @Test
    void getDepartmentById() throws Exception {

        given(departmentService.getDepartment(1L)).willReturn(department);
//        Mockito.when(departmentService.getDepartment(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.depertmentName").value(department.getDepertmentName()));

    }
}