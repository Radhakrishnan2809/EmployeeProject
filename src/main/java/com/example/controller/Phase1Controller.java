package com.example.controller;



import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.DepartmentRepository;
import com.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class Phase1Controller {


    @Autowired
    private IEmployeeRepository employeeRepository;


    @Autowired
    private DepartmentRepository departmentRepository;


    /*create an Employee*/

    @PostMapping("/employeeCreation")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    /*Update Employee name, Salary and department (one or more values) */

    @PutMapping("/employeeUpdate/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable(value = "id") Integer employeeId, @Valid @RequestBody Employee employeeDetails)
            throws ResourceNotFoundException {
        Employee employee =
                employeeRepository
                        .findById(employeeId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + employeeId));
        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartmentId(employeeDetails.getDepartmentId());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }




    /* 3. Map department to employee */




    /* 4. Create department */

    @PostMapping("/departmentCreation")
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }



    /* 5. Update department name */

    @PutMapping("/departmentUpdate/{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable(value = "id") Integer departmentId, @Valid @RequestBody Department departmentDetails)
            throws ResourceNotFoundException {
        Department department =
                departmentRepository
                        .findById(departmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + departmentId));
        department.setName(departmentDetails.getName());
        final Department updatedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }




    /*  6. Get employee by Id
     */

    @GetMapping("/employeeDetailsGetting/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId)
            throws ResourceNotFoundException {
        Employee employee =
                employeeRepository
                        .findById(employeeId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }






    /*  7. Get department by Id
     */

    @GetMapping("/departmentDetailsGetting/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Integer departmentId)
            throws ResourceNotFoundException {
        Department department =
                departmentRepository
                        .findById(departmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + departmentId));
        return ResponseEntity.ok().body(department);
    }






    /* 8. Get all employees by department Id
*/


    @GetMapping("/employeeDetailsGettingByDepartmentId/{id}")
    public ResponseEntity<List<Employee>> getEmployeeByDepartmentId(@PathVariable(value = "departmentId") Integer departmentId)
            throws ResourceNotFoundException {
        Employee employee =
                employeeRepository.findAllById(departmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + departmentId));
        return ResponseEntity.ok().body(employee);
    }

    

}
