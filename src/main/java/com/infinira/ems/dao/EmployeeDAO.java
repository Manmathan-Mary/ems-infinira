package com.infinira.ems.dao;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.text.MessageFormat;
//import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.log4j.Level;
import com.infinira.ems.model.Employee;
import com.infinira.ems.EMSApplication;
import com.infinira.ems.customexception.EMSException;
import com.infinira.ems.util.DBUtil;
//import com.infinira.ems.util.LogUtil;
import com.infinira.ems.util.ResourceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeDAO {
	//private static Logger logger = LogUtil.getInstance().getLogger();
    private static final Logger logger = LogManager.getLogger("com.infinira.ems.dao");
	private static ResourceUtil resourceUtil = ResourceUtil.getInstance();

	
	
	public static long create(Employee emp) {
		if (emp == null ) {
			throw new EMSException(resourceUtil.getMessage("EMS-0005"), null);
		}
		logger.debug("Creating employee {}", emp.getFirstName());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int createStatus = 0;
		long empId;
		
		try {
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
			setValue(pstmt, emp, true);
			createStatus = pstmt.executeUpdate();
			if(createStatus == 0) {
				logger.error(resourceUtil.getMessage("EMS-0006", emp.getFirstName()));
				throw new EMSException(resourceUtil.getMessage("EMS-0006", emp.getFirstName()), null);
			}
			rs = pstmt.getGeneratedKeys();
			if (!rs.next()) {
				logger.error(resourceUtil.getMessage("EMS-0006", emp.getFirstName()));
				throw new EMSException(resourceUtil.getMessage("EMS-0006", emp.getFirstName()), null);
			}
			empId = rs.getLong(1);
			emp.setEmpId(empId);
			logger.debug("Employee created {}",empId);
			return empId;			
		} catch (Throwable th) {
			logger.error(resourceUtil.getMessage("EMS-0006", emp.getFirstName()));
			throw new EMSException(resourceUtil.getMessage("EMS-0006", emp.getFirstName()), th);
		} finally {
				DBUtil.close(rs, pstmt, conn);
		}	
	}
	
	public static Optional<Employee> get(long empId) {
		if(empId <= 0) {
			throw new EMSException(resourceUtil.getMessage("EMS-0004", empId), null);
		}
		logger.debug("Getting employee details for emloyee ID {} ", empId);
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try {
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(GET_QUERY);
			pstmt.setLong(1, empId);
			rs = pstmt.executeQuery();
			if(!rs.next()){
				throw new EMSException(resourceUtil.getMessage("EMS-0002", empId),null);
			}
			emp = getValue(rs);
			logger.debug("Employee details got for emloyee ID {} ", empId);
			logger.debug("Employee details:{}",emp.toString());
			return Optional.ofNullable(emp);			
		} catch (Throwable th) {
			logger.error(resourceUtil.getMessage("EMS-0003", empId));
			throw new EMSException(resourceUtil.getMessage("EMS-0003", empId), th);
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}
	
	private static Employee getValue(ResultSet rs) throws SQLException {
		int ix = 1;
		Employee emp = new Employee(rs.getLong(ix),rs.getString(++ix),rs.getString(++ix),rs.getString(++ix));
		emp.setMiddleName(rs.getString(++ix));
		emp.setSalary(rs.getInt(++ix));
		emp.setEmail(rs.getString(++ix));
		emp.setDesignation(rs.getString(++ix));
		emp.setDepartmentId(rs.getShort(++ix));
		emp.setDateOfBirth(rs.getObject(++ix, LocalDate.class));
		emp.setDateOfHire(rs.getObject(++ix, LocalDate.class));
		emp.setDateOfLeaving(rs.getObject(++ix, LocalDate.class));
		emp.setStatus(rs.getString(++ix));
		emp.setManagerId(rs.getInt(++ix));
		emp.setMaritalStatus(rs.getString(++ix));
		emp.setDifferentlyAbled(rs.getBoolean(++ix));
		emp.setPassPortNo(rs.getString(++ix));
		emp.setBloodGroup(rs.getString(++ix));
		emp.setGender(rs.getString(++ix));
		emp.setTaxId(rs.getString(++ix));
		emp.setNationalId(rs.getString(++ix));
		emp.setAddress1(rs.getString(++ix));
		emp.setAddress2(rs.getString(++ix));
		emp.setCity(rs.getString(++ix));
		emp.setState(rs.getString(++ix));
		emp.setCountry(rs.getString(++ix));
		emp.setPostalCode(rs.getString(++ix));
		emp.setDateOfCreation(rs.getObject(++ix, OffsetDateTime.class));
		emp.setLastUpdate(rs.getObject(++ix, OffsetDateTime.class));	
		return emp;
	}	
	
	public static List<Employee> getAll(){
		List<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;	
		Statement pstmt = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try{
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(GET_ALL_QUERY);
			while(rs.next()) {
				emp = getValue(rs);
				employees.add(emp);
			}
			return employees;
		} catch (Throwable th) {
			throw new EMSException(resourceUtil.getMessage("EMS-0004"), th);
		} 
		finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}
	
	private static int setValue(PreparedStatement pstmt, Employee emp, boolean setCreate) throws SQLException {
		int ix = 1;
		pstmt.setString(ix, emp.getFirstName());
		pstmt.setString(++ix, emp.getLastName());
		pstmt.setString(++ix, emp.getMobileNo());
		pstmt.setString(++ix, emp.getMiddleName());
		pstmt.setInt(++ix, emp.getSalary());
		pstmt.setString(++ix, emp.getEmail());
		pstmt.setString(++ix, emp.getDesignation());
		pstmt.setShort(++ix, emp.getDepartmentId());
		pstmt.setObject(++ix, emp.getDateOfBirth());
		pstmt.setObject(++ix, emp.getDateOfHire());
		pstmt.setObject(++ix, emp.getDateOfLeaving());				
		pstmt.setString(++ix, emp.getStatus());
		pstmt.setInt(++ix, emp.getManagerId());
		pstmt.setObject(++ix, emp.getMaritalStatus().toLowerCase(), Types.OTHER);
		pstmt.setBoolean(++ix, emp.getDifferentlyAbled());
		pstmt.setString(++ix, emp.getPassPortNo()); 
		pstmt.setObject(++ix, emp.getBloodGroup().toLowerCase(), Types.OTHER);
		pstmt.setObject(++ix, emp.getGender().toLowerCase(), Types.OTHER);
		pstmt.setString(++ix, emp.getTaxId()); 
		pstmt.setString(++ix, emp.getNationalId()); 
		pstmt.setString(++ix, emp.getAddress1());
		pstmt.setString(++ix, emp.getAddress2());
		pstmt.setString(++ix, emp.getCity()); 
		pstmt.setString(++ix, emp.getState()); 	
		pstmt.setString(++ix, emp.getCountry());
		pstmt.setString(++ix, emp.getPostalCode());
		
		if(!setCreate){
			pstmt.setObject(++ix,emp.getLastUpdate());
		}
		return ix;
	}
	
	public static long update(Employee emp) {
		if (emp == null ) {
			throw new EMSException(resourceUtil.getMessage("EMS-0007"), null);
		}
		logger.debug("Updating employee details for emloyee ID {} ",emp.getEmpId());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long updatedRowCount = 0;
		
		try {
			int ix;
			conn =  DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(UPDATE_QUERY);
			ix = setValue(pstmt, emp, false);
			pstmt.setLong(++ix, emp.getEmpId());
			updatedRowCount = pstmt.executeUpdate();
			if (updatedRowCount == 0) {
				throw new EMSException(resourceUtil.getMessage("EMS-0008", emp.getEmpId(), emp.getFirstName()),null);
			}
			logger.debug("Updated employee details for emloyee ID {} ",emp.getEmpId());
			return updatedRowCount;			
		} catch (Throwable th) {
			logger.error(resourceUtil.getMessage("EMS-0008", emp.getEmpId(), emp.getFirstName()));
			throw new EMSException(resourceUtil.getMessage("EMS-0008", emp.getEmpId(), emp.getFirstName()),th);
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}		
	}
	
	public static long delete(long empId){
		if(empId <= 0) {
			new EMSException(resourceUtil.getMessage("EMS-0009"), null);
		}
		logger.debug("Deleting employee details for emloyee ID {} ",empId);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long deletedRowCount = 0;
		
		try{
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(DELETE_QUERY);
			pstmt.setLong(1, empId);
			deletedRowCount = pstmt.executeUpdate();
			if (deletedRowCount == 0) {
				new EMSException(resourceUtil.getMessage("EMS-0010"), null);
			}
			logger.debug("Deleted employee details for emloyee ID {} ",empId);
			return deletedRowCount;			
		} catch (Throwable th) {
			logger.error(resourceUtil.getMessage("EMS-0011", empId));
			throw new EMSException(resourceUtil.getMessage("EMS-0011", empId), null);
		} finally {
				DBUtil.close(rs, pstmt, conn);
		}		
	}
	
	private static final String CREATE_COLUMNS = """
										first_name, last_name, mobile_no, middle_name, 
										salary, email, designation, department_id,
										date_of_birth, date_of_hire, date_of_leaving, status, manager_id,
										marital_status, differently_abled, passport_no, blood_group, gender,
										tax_id, national_id, address1, address2, city, state ,country ,postal_code
										""";
	private static final String SELECT_COLUMNS = "emp_id, " + CREATE_COLUMNS + ", date_of_creation, last_update";
	private static final String UPDATE_COLUMNS = """
												first_name = ?, last_name = ?, mobile_no = ?, middle_name = ?, 
												salary = ?, email = ?, designation = ?, department_id = ?,
												date_of_birth = ?, date_of_hire = ?, date_of_leaving = ?, status = ?, manager_id = ?,
												marital_status = ?, differently_abled = ?, passport_no = ?, blood_group = ?, gender = ?,
												tax_id = ?, national_id = ?, address1 = ?, address2 = ?, city = ?, state = ?, country = ?,
												postal_code = ?, last_update = ?
												""" ;
	
	private static final String GET_QUERY = "SELECT " + SELECT_COLUMNS + " FROM employee WHERE emp_id = ?;";
	private static final String GET_ALL_QUERY = "SELECT " + SELECT_COLUMNS + " FROM employee;";
	private static final String CREATE_QUERY = "INSERT INTO  employee(" + CREATE_COLUMNS +") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	private static final String UPDATE_QUERY = "UPDATE employee SET " + UPDATE_COLUMNS + " WHERE emp_id = ?;";
	private static final String DELETE_QUERY = "DELETE FROM employee WHERE emp_id = ?";
}
	