package com.example.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="Department")
@Getter
@Setter
@ToString
public class Department {

    private static final long serialVersionUID=1L;

    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

}
