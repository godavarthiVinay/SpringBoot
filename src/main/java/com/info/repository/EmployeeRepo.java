package com.info.repository;

import com.info.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Long> {
}
