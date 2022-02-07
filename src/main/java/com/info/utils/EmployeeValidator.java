package com.info.utils;

import com.info.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Employee.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee emp=(Employee)target;

        if(emp.getEname().isEmpty() || emp.getEname().length() <5 || emp.getEname().length()>30){
            errors.rejectValue("ename","ename","Name Should be greater than 5 characters and less than 30 characters");
        }
        if(emp.getGender() ==null || emp.getGender().isEmpty()){
            errors.rejectValue("gender","gender","Please Select Gender");
        }
        if(emp.getJob().isEmpty()|| emp.getJob().length()<5 || emp.getJob().length()>30 ){
            errors.rejectValue("job","job","Job Should be greater than 5 characters and less than 30 characters");
        }
        if(emp.getEsal().isNaN() || emp.getEsal()<10000 || emp.getEsal()>200000 ){
            errors.rejectValue("esal","esal","Salary should be in range  between 10000 to 200000");
        }
        if(emp.getDeptNo() ==null || emp.getDeptNo()<=0 || emp.getDeptNo()>1000 ){
            errors.rejectValue("deptNo","deptNo","DepartmentNo Should be in range between 1 to 1000");
        }

    }
}
