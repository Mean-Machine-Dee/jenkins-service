package com.meanmachine.tutorial.service;

import com.meanmachine.tutorial.entity.Department;
import com.meanmachine.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DepartmentServiceTest {


    @Autowired
    private DepartmentService departmentService;


    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .depertmentName("IT")
                        .address("Nairobi")
                        .code("IT-006")
                        .depertmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findBydepertmentName("IT"))
                .thenReturn(department);
    }



    @Test
    @DisplayName("Get data based on valid department")

    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){

        String departmentName = "IT";
        Department found = departmentService.getByName(departmentName);
        assertEquals(departmentName,found.getDepertmentName());
    }
}