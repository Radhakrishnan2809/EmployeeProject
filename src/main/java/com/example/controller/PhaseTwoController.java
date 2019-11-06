package com.example.controller;

import com.example.JpaSpecification.EmployeeSpecification;
import com.example.JpaSpecification.SearchCriteria;
import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

public class PhaseTwoController {

@Autowired
private IEmployeeRepository employeeRepository;



        /* getting all employee by department ID */
        @RequestMapping(value = "/employeeByDepartmentId/{id}", //
                method = RequestMethod.GET, //
                produces = { MediaType.APPLICATION_JSON_VALUE})
        @ResponseBody
        public List<Employee> getEmployees(@PathVariable("id") Integer Id) {
            EmployeeSpecification spec=new EmployeeSpecification(new SearchCriteria("Id",":","?"));
            List<Employee> result=employeeRepository.findAll(spec);
            return result;
        }


        /*getting all employee whose salary greater than 10K*/

    @RequestMapping(value = "/employeeBySalary", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Employee> getEmployees() {
        EmployeeSpecification spec1 = new EmployeeSpecification(new SearchCriteria("salary", ">", "10000"));
        List<Employee> result=employeeRepository.findAll(spec1);
        return result;
    }


        /*getting allemployes whose salary greater than 10k and given department ID */

        @RequestMapping(value = "/employeeByDepartmentIdAndSalary/{id}", //
                method = RequestMethod.GET, //
                produces = { MediaType.APPLICATION_JSON_VALUE})
        @ResponseBody
        public List<Employee> getEmployeesBySalaryAndId(@PathVariable("id") Integer Id) {
            EmployeeSpecification spec=new EmployeeSpecification(new SearchCriteria("Id",":","?"));
            EmployeeSpecification spec1 = new EmployeeSpecification(new SearchCriteria("salary", ">", "10000"));
            List<Employee> result=employeeRepository.findAll(Specification.where(spec1).and(spec));
            return result;
        }



    }




