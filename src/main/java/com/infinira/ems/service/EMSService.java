package com.infinira.ems.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.infinira.ems.dao.EmployeeDAO;
import com.infinira.ems.model.Employee;
import com.infinira.ems.service.IEMSService;
import java.util.Optional;
import java.util.List;

@Service
public class EMSService implements IEMSService<Employee> {
	
	public long create(Employee emp) {
		return EmployeeDAO.create(emp);
	}
	
	@Cacheable(value = "employees", key = "#empId")
	public Optional<Employee> get(long empId) {
		return EmployeeDAO.get(empId);
	}
	
	public List<Employee> getAll() {
		return EmployeeDAO.getAll();
	}
	
    @CachePut(value = "employees", key = "#emp.empId")
	public long update(Employee emp) {
		return EmployeeDAO.update(emp);
	}
	
    
    @CacheEvict(value = "employees", allEntries=true)
	public long delete(long empId) {
		return EmployeeDAO.delete(empId);
	}
}