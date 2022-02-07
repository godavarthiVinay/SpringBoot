package com.info.service;

import com.info.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IEmployeeService {

    public Iterable<Employee> getEmpReports();
    public Page<Employee> getEmpReportsByPage(Pageable pageable);
    public Employee getEmpDetails(long id) throws Exception;
    public String insertEmployee(Employee emp);


    List<String> getGenders();
}
