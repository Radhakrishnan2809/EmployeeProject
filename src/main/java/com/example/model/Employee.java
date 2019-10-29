package com.example.model;

import com.example.model.Designation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Employee")
@EntityListeners(AuditingEntityListener.class)
@Data
@Getter
@Setter
@ToString

public class Employee implements Serializable{


        private static final long serialVersionUID=1L;

        @Id
        @Column(name="id")
        private Integer id;

        @Column(name="name")
        private String name;

        @Column(name="salary")
        private Integer salary;

        @Column(name="department_id")
        private Integer departmentId;

        @Column(name="manager_id")
        private Integer managerId;

        @ManyToOne
        @JoinColumn(name="departmentId")
        private Employee employee;


        @Enumerated(EnumType.STRING)
        private Designation designation;

    }
