package com.infinira.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.MediaType;
import java.util.Optional;
import java.util.List;
import com.infinira.ems.model.Employee;
import com.infinira.ems.service.EMSService;

@RestController
@RequestMapping(path="/ems")
@CrossOrigin(origins = "http://localhost:4200")
public class EMSController {
	@Autowired
	private EMSService emsService;
	
	@RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public long create(@RequestBody Employee emp){
		return (emsService.create(emp));
    }
	
	@RequestMapping(value = "/employee/get/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<Employee> get(@PathVariable("employeeId") int employeeId)  {
		Optional<Employee> employee = emsService.get(employeeId);
		if(employee.isPresent()) {
			return ResponseEntity.ok().body(employee.get());
		} else {
			return ResponseEntity.notFound().build();
		}
    }
	
    @RequestMapping(value = "/employee/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<List<Employee>>(emsService.getAll(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public long update(@RequestBody Employee emp){
        return emsService.update(emp);
    }
	
	@RequestMapping(value = "/employee/delete/{employeeId}", method = RequestMethod.DELETE)
    public long delete(@PathVariable long employeeId){
        return emsService.delete(employeeId);
    }
}