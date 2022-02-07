package com.info.service;

import com.info.entity.Employee;
import com.info.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicImpl implements IEmployeeService{

    private EmployeeRepo employeeRepo;

    @Autowired
    public void setEmployeeRepo(@Qualifier("employeeRepo") EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @Override
    public Iterable<Employee> getEmpReports() {

        return employeeRepo.findAll(Sort.by(Sort.Direction.ASC,"empNo"));
    }

    @Override
    public Page<Employee> getEmpReportsByPage(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }


    @Override
    public Employee getEmpDetails(long id) throws Exception {
        Optional<Employee> opt= employeeRepo.findById(id);
        if(opt.isPresent()){
            return  opt.get();
        }else {
            throw new Exception("No Employee Details found");
        }
    }

    @Override
    public String insertEmployee(Employee emp) {
        return "Employee saved with EmpId:- "+employeeRepo.save(emp).getEmpNo();
    }

    @Override
    public List<String> getGenders() {
        List<String> genders=new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        genders.add("Others");
        return genders;
    }


}
