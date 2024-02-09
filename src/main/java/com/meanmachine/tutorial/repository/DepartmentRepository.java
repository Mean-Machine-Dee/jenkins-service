package com.meanmachine.tutorial.repository;


import com.meanmachine.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findBydepertmentName(String name);

}
