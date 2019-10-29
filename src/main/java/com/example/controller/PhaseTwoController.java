package com.example.controller;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PhaseTwoController {

@Autowired
private IEmployeeRepository employeeRepository;



   /*  1. Get Employee By ID. */

/*already done in controller one */


   /* 2. Get all employees whose salary greater than 10K (add new column salary) order by employee name Asc (case insensitive) */
    @GetMapping("/GettingEmployeeDetails")
    public List<Employee> getEmployees(){

        return employeeRepository.findEmployeeBySalary();
    }




    /*  3. Get all employees whose salary greater than 10K and for a given department Id order by Salary Desc
     */

    @RequestMapping(value = "/employeeByDepartmentIdAndSalary/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Employee> getEmployees(@PathVariable("id") Integer Id) {
        List<Employee> list =employeeRepository.findByDepartmentIdAndSalary(Id);
        return list;
    }


    @RequestMapping(value = "/employeeByDesignation/{designation}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Employee> getEmployeesByDesignation(@PathVariable("designation") String Designation) {
        List<Employee> list =employeeRepository.findByDesignation(Designation);
        return list;
    }



}
