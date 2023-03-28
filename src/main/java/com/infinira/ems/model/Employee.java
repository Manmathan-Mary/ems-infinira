package com.infinira.ems.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.io.Serializable;

enum Gender{
	MALE,FEMALE,TRANSGENDER;
}
enum MaritalStatus
{
	SINGLE,MARRIED;
}
enum BloodGroup
{
	OPOS,APOS,BPOS,ABPOS,ANEG,BNEG,ABNEG;
}

public class Employee implements Serializable
{
	private static final long serialVersionUID = 5560221391479816650L;
	private long empId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String designation;
	private int salary;
	private String email;
	private String mobileNo;
	private LocalDate dateOfBirth;
	private short departmentId;
	private LocalDate dateOfHire;
	private LocalDate dateOfLeaving;
	private String status;
	private int managerId;
	private MaritalStatus maritalStatus;
	private boolean differentlyAbled;
	private String passPortNo;
	private BloodGroup bloodGroup;
	private Gender gender;
	private String taxId;
	private String nationalId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private OffsetDateTime dateOfCreation;
	private OffsetDateTime lastUpdate;
	
	public Employee(long empId, String firstName, String lastName, String mobileNo) {
		if(empId <= 0)
		{
			throw new IllegalArgumentException("Invalid Employee ID");
		}
		this.empId = empId;
		
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
		
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	
		if (mobileNo == null || !mobileNo.matches("^[+]?(?:[0-9]\\x20?){6,14}[0-9]$")) {
			throw new IllegalArgumentException("Invalid Mobile No");
		}
		this.mobileNo = mobileNo;
	}
	
	
	public long getEmpId() {
		return this.empId;
	}
	
	public void setEmpId (long empId) {
		if(empId <= 0)
		{
			throw new IllegalArgumentException("Invalid Employee ID");
		}
		this.empId = empId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	
	public String getDesignation() {
		return this.designation;
	}
	
	public void setDesignation(String designation) {
		if(designation == null || designation.isEmpty()) {
			throw new IllegalArgumentException("Invalid designation");
		}
		this.designation = designation;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int salary) {
		if(salary <= 0) {
			throw new IllegalArgumentException("Invalid salary amount");
		}
		this.salary = salary;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		if (email == null || email.trim().isEmpty() || !email.matches("^[a-zA-Z0-9]+[@]\\w*.\\w{3}")) {
			throw new IllegalArgumentException("Invalid mail ID");
		}
		this.email=email;
	}
	
	public String getMobileNo() {
		return this.mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		if (mobileNo == null || mobileNo.isEmpty() || !mobileNo.matches("^[+]?(?:[0-9]\\x20?){6,14}[0-9]$")) {
			throw new IllegalArgumentException("Invalid Mobile No");
		}
		this.mobileNo = mobileNo;
	}
	
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public short getDepartmentId() {
		return this.departmentId;
	}
	
	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}
	
	public LocalDate getDateOfHire() {
		return this.dateOfHire;
	}
	
	public void setDateOfHire(LocalDate dateOfHire) {
		this.dateOfHire = dateOfHire;
	}
	
	public LocalDate getDateOfLeaving() {
		return this.dateOfLeaving;
	}
	
	public void setDateOfLeaving(LocalDate dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getManagerId(){
		return this.managerId;
	}
	
	public void setManagerId(int managerId){
		this.managerId = managerId;
	}
	
	public String getMaritalStatus(){
		return this.maritalStatus.toString();
	}
	
	public void setMaritalStatus(String maritalStatus) {
		
		try {
			this.maritalStatus = MaritalStatus.valueOf(maritalStatus.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid Marital Status");
		}
	}
	
	public boolean getDifferentlyAbled() {
		return this.differentlyAbled;
	}
	
	public void setDifferentlyAbled(boolean differentlyAbled) {
		this.differentlyAbled = differentlyAbled;
	}
	
	public String getPassPortNo() {
		return passPortNo;
	}
	
	public void setPassPortNo(String passPortNo) {
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.passPortNo = passPortNo;
	}
	
	public String getBloodGroup() {
		return this.bloodGroup.toString();
	}
	
	public void setBloodGroup(String bloodGroup){
		if (bloodGroup == null || bloodGroup.trim().isEmpty()) {
			throw new IllegalArgumentException("Blood group");
		}
		try {
		this.bloodGroup=BloodGroup.valueOf(bloodGroup.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid Blood Group");
		}
	}
	
	public String getGender() {
		return this.gender.toString();
	}
	
	public void setGender(String gender) {
		if (gender == null || gender.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid gender");
		}
		try{
			this.gender = Gender.valueOf(gender.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid Gender Value");
		}
	}
	
	public String getTaxId() {
		return this.taxId;
	}
	
	public void setTaxId(String taxId) {
		if(taxId == null || taxId.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal Tax ID");
		}
		this.taxId = taxId;
	}
	
	public String getNationalId() {
		return this.nationalId;
	}
	
	public void setNationalId(String nationalId) {
		if(nationalId == null || nationalId.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal National ID");
		}
		this.nationalId = nationalId;
	}
	
	public String getAddress1() {
		return this.address1;
	}
	
	public void setAddress1(String address1) {
		if(address1 == null || address1.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal Address 1");
		}
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return this.address2;
	}
	
	public void setAddress2(String address2) {
		if(address2 == null || address2.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal Address 2");
		}
		this.address2 = address2;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		if(city == null || city.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal City");
		}
		this.city = city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		if(state == null || state.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal state value");
		}
		this.state = state;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String country) {
		if(country == null || country.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal Tax ID");
		}
		this.country = country;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		if(postalCode == null || postalCode.trim().isEmpty()) {
			throw new IllegalArgumentException("Illegal PostalCode");
		}
		this.postalCode = postalCode;
	}
	
	public OffsetDateTime getDateOfCreation() {
		return this.dateOfCreation;
	}
	
	public void setDateOfCreation(OffsetDateTime dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	public OffsetDateTime getLastUpdate() {
		return this.lastUpdate;
	}
	
	public void setLastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Employee ID: ").append(empId).append("\n");
		sb.append("Name: ").append(firstName).append(" ").append(middleName).append(" ").append(lastName).append("\n");
		sb.append("Designation: ").append(designation).append("\n");
		sb.append("Salary: $").append(salary).append("\n");
		sb.append("Email: ").append(email).append("\n");
		sb.append("Mobile: ").append(mobileNo).append("\n");
		sb.append("Date of Birth: ").append(dateOfBirth.toString()).append("\n");
		sb.append("Department ID: ").append(departmentId).append("\n");
		sb.append("Date of Hire: ").append(dateOfHire.toString()).append("\n");
		sb.append("Date of Leaving: ").append(dateOfLeaving == null ? "N/A" : dateOfLeaving.toString()).append("\n");
		sb.append("Status: ").append(status).append("\n");
		sb.append("Manager ID: ").append(managerId).append("\n");
		sb.append("Marital Status: ").append(maritalStatus.toString()).append("\n");
		sb.append("Differently Abled: ").append(differentlyAbled ? "Yes" : "No").append("\n");
		sb.append("Passport Number: ").append(passPortNo).append("\n");
		sb.append("Blood Group: ").append(bloodGroup.toString()).append("\n");
		sb.append("Gender: ").append(gender.toString()).append("\n");
		sb.append("Tax ID: ").append(taxId).append("\n");
		sb.append("National ID: ").append(nationalId).append("\n");
		sb.append("Address: ").append(address1).append(", ").append(address2).append(", ")
				.append(city).append(", ").append(state).append(", ").append(country).append(", ")
				.append(postalCode).append("\n");
		sb.append("Date of Creation: ").append(dateOfCreation.toString()).append("\n");
		sb.append("Last Update: ").append(lastUpdate.toString()).append("\n");

		return sb.toString();
	}
}
