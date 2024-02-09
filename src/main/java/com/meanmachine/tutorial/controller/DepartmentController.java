package com.meanmachine.tutorial.controller;


import com.meanmachine.tutorial.entity.Department;
import com.meanmachine.tutorial.errors.DepartmentNotFoundException;
import com.meanmachine.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOG = LoggerFactory.getLogger(Department.class);
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@Valid  @RequestBody  Department department){
        LOG.info("We are creating depertment");
        return departmentService.saveDeparment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDeparments(){
        return departmentService.getDeparments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartMent(@PathVariable(name = "id") Long id){
        departmentService.delete(id);
        return "Department deleted successfully";
    }

//    @PutMapping("/departments/{id}")
//    public Department updateDepartment(@PathVariable(name = "id") Long id, @RequestBody Department department){
//        return departmentService.updateDepartment(id,department);
//    }

    @GetMapping("/departments/name/{name}")
    public Department fetchByName(@PathVariable String name){
        return departmentService.getByName(name);
    }


}
