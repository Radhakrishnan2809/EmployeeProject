package com.example.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="Department")
@Entity
@Data
@Getter
@Setter
@ToString
public class Department {

    private static final long serialVersionUID=1L;


    @Column(name="departmentId")
    private Integer departmentId;

    @Column(name="name")
    private String departmentName;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employeeList=new ArrayList<>();

}
