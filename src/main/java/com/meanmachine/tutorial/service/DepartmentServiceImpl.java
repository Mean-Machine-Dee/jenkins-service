package com.meanmachine.tutorial.service;


import com.meanmachine.tutorial.entity.Department;
import com.meanmachine.tutorial.errors.DepartmentNotFoundException;
import com.meanmachine.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{



    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDeparment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDeparments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long id) throws DepartmentNotFoundException {
        System.out.println("Department id is " + id);
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){ throw new DepartmentNotFoundException("Department not found;");}
        return department.get();


    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id) {
        return null;
    }

    @Override
    public Department getByName(String name) {
        System.out.println("Stringpassed " + name + " " +  departmentRepository.findBydepertmentName(name));
        return departmentRepository.findBydepertmentName(name);
    }

//    @Override
//    public Department updateDepartment(Long id, Department department) {
//        Department dbDept = departmentRepository.findById(id).get();
//        //TODO:UPDATE DEPARTMENT
//        return null;
//    }
}
