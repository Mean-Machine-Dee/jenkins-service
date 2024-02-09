package com.meanmachine.tutorial.service;

import com.meanmachine.tutorial.entity.Department;
import com.meanmachine.tutorial.errors.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDeparment(Department department);

    List<Department> getDeparments();

    Department getDepartment(Long id) throws DepartmentNotFoundException;

    void delete(Long id);

    Department updateDepartment(Long id);

    Department getByName(String name);
}
