package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {



 @Query("select * from employee where department_id=?")
 List<Employee> getEmployeesByDepartmentId(Integer departmentId);

@Query("select * from employee where salary>10000 order by  name asc")
List<Employee> findEmployeeBySalary ();

@Query("select * from employee where salary>10000 and department_id=? order by salary desc")
List<Employee> findByDepartmentIdAndSalary(Integer departmentId);

@Query("")
List<Employee> findByDesignation(String Designation);


}
