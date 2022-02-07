package com.info.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_TEST")
@Data
@SQLDelete(sql = "UPDATE EMPLOYEE_TEST set status=0 where ID=?")
@Where(clause = "ACTIVE=1")
public class Employee {

    @Id
    @SequenceGenerator(name = "empSeq",sequenceName = "emp_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "empSeq",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long empNo;

    @Column(name = "NAME")
    private String ename;

    @Column(name="GENDER")
    private String gender;

    @Column(name="JOB")
    private String job;

    @Column(name="SALARY")
    private Double esal=10000.0;

    @Column(name="DEPTNO")
    private Integer deptNo;

    @Column(name = "JoiningDate")
    private Date doj;

    @Column(name = "DOB")
    private LocalDateTime dob;

    @Column(name = "loginTime")
    private LocalTime loginTime ;

    @Column(name = "created_datetime")
    private LocalDateTime createdDateTime ;

    @Column(name = "ACTIVE")
    private boolean status=true;


    @Transient
    private boolean vflag=false;


}
