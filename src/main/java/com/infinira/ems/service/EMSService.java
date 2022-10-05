package com.infinira.ems.service;

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
	
	public Optional<Employee> get(long empId) {
		return EmployeeDAO.get(empId);
	}
	
	public List<Employee> getAll() {
		return EmployeeDAO.getAll();
	}
	
	public long update(Employee emp) {
		return EmployeeDAO.update(emp);
	}
	
	public long delete(long empId) {
		return EmployeeDAO.delete(empId);
	}
}