import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.hamcrest.MatcherAssert.assertThat;
	
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import com.infinira.ems.model.Employee;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Tests for EMSApps")
public class EMSControllerTest { 
	private static final int PORT = 8083;
	private static final String BASE_PATH = "/ems/employee/";
	private static final String BASE_URI = "http://localhost";
    @BeforeAll
    public static void setup() {
		port = PORT;
        basePath = BASE_PATH;
        baseURI = BASE_URI;
	}

  @Test 
  @Order(1)
  public void testCreateEmployee() {
	System.out.println("Create Method Start");
	Employee employee = getEmployee();
	Response response = with()
							.contentType("application/json")
							.body(employee)
							.when()
							.request("POST", "/create")
							.then()
							.statusCode(200)
							.assertThat()
							.extract()
							.response();
	ResponseBody body = response.getBody();
	assertThat(body.asString(),equalTo(String.valueOf(employee.getEmpId())));
	System.out.println("Create Method End");
  }
  
  @Test
  @Order(2)
  public void testGetEmployee() {
	System.out.println("Get Method Start");
	long empId = 1;
	given()
	      .pathParam("employeeId",empId)
		  .when()
		  .get("/get/{employeeId}")
	      .then()
		  .statusCode(200)
		  .assertThat()
		  .body("firstName",equalTo("Hamsath"));
	System.out.println("Get Method End");
  }
  
  @Test
  @Order(3)
  public void testGetAllEmployee() {
	System.out.println("GetAll Method Start");
	given()
		   .when()
		   .get("/getall")
		   .then()
		   .statusCode(200);
	System.out.println("GetAll Method End");
  }
  
  @Test 
  @Order(4)
  public void testUpdateEmployee(){
	System.out.println("Update Method Start");
	Employee employee = getEmployee();
	long empId = 1;
	employee.setFirstName("John");
	employee.setEmpId(empId);
	Response response = with()
							.contentType("application/json")
							.body(employee)
							.when()
							.request("PUT", "/update")
							.then()
							.statusCode(200)
							.assertThat()
							.extract()
							.response();
	ResponseBody body = response.getBody();
	assertThat(body.asString(),equalTo(String.valueOf(employee.getEmpId())));
	testGet(empId);
	System.out.println("Update Method End");
  }
  public void testGet(long empId) {
	  given()
		  .pathParam("employeeId",empId)
	      .when()
		  .get("/get/{employeeId}")
	      .then()
		  .statusCode(200)
	      .assertThat()
		  .body("firstName",equalTo("John"));
  }

  @Test 
  @Order(5)
  public void testDeleteEmployee(){
	System.out.println("Delete Method Start");
	long id = 1;
	Employee employee = getEmployee();
	Response response = with()
							.pathParam("employeeId",id)
							.contentType("application/json")
							.body(employee)
							.when()
							.request("DELETE", "/delete/{employeeId}")
							.then()
							.statusCode(200)
							.assertThat()
							.extract()
							.response();
	ResponseBody body = response.getBody();
	assertThat(body.asString(),equalTo(String.valueOf(employee.getEmpId())));
	System.out.println("Update Method End");
  }

  private static Employee getEmployee() {
		long empId = 1;
		String firstName = "Hamsath";
		String middleName = "Nisha";
		String lastName = "Jaffer";
		String designation = "Teacher";
		int	salary = 25000;
		boolean differentlyAbled = false;
		int	managerId = 123;
		short departmentId = 12;
		String email = "hamsath1996@gmail.com";
		String maritalStatus = "SINGLE";
		String gender = "FEMALE";
		String bloodGroup="OPOS";
		String status = "inactive";
		String passPortNo = "123456789";
		String taxId = "4654654897";
		String nationalId = "467896415133493";
		String mobileNo = "+91 987564656056";
		String address1 = "Heliperiya";
		String address2 = "Kattapana";
		String city = "Idukki";
		String state = "Kerala";
		String country = "india";
		String 	postalCode = "628866";
		ZoneOffset zoneOffSet= ZoneOffset.of("+05:30");
		OffsetDateTime dateOfCreation = OffsetDateTime.of(2022,06,14,4,50,6,12345,zoneOffSet);
		LocalDate dateOfHire =  LocalDate.of(2022,06,14);
		LocalDate dateOfLeaving = LocalDate.of(2022,06,03);
		OffsetDateTime lastUpdate = OffsetDateTime.of(2045,06,14,4,50,6,12345,zoneOffSet);
		LocalDate dateOfBirth = LocalDate.of(2022,06,03);
		
		try {
			Employee emp = new Employee(1,firstName,lastName,mobileNo);
			emp.setEmpId(empId);
			emp.setMiddleName(middleName);
			emp.setDesignation(designation);
			emp.setSalary(salary);
			emp.setEmail(email);
			emp.setMaritalStatus(maritalStatus);
			emp.setGender(gender);
			emp.setDepartmentId(departmentId);
			emp.setBloodGroup(bloodGroup);
			emp.setStatus(status);
			emp.setManagerId(managerId);
			emp.setDifferentlyAbled(differentlyAbled);
			emp.setPassPortNo(passPortNo);
			emp.setTaxId(taxId);
			emp.setNationalId(nationalId);
			emp.setAddress1(address1);
			emp.setAddress2(address2);
			emp.setCity(city);
			emp.setState(state);
			emp.setCountry(country);
			emp.setPostalCode(postalCode);
			emp.setLastUpdate(lastUpdate);
			emp.setDateOfCreation(dateOfCreation);
			emp.setDateOfBirth(dateOfBirth);
			emp.setDateOfHire(dateOfHire);
			emp.setDateOfLeaving(dateOfLeaving);
			return emp;
		}catch(Exception ex) {
			throw new RuntimeException("Failed to create an object");
		}
		}
}