package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private String firstName;
	private String lastName;
	private String employeeID;
	private String active;
	private String role;
	private String manager;
	private String passWord;
	private UUID id;
	private LocalDateTime createdOn;
	
	public String getFirstName() {
		return this.firstName;
	}
	public Employee setFirstName(String first_name) {
		this.firstName = first_name;
		return this;
	}

	public String getLastName() {
		return this.lastName;
	}
	public Employee setLastName(String last_name) {
		this.lastName = last_name;
		return this;
	}

	public String getEmployeeID() {
		return this.employeeID;
	}
	public Employee setEmployeeID(String employee_id) {
		this.employeeID = employee_id;
		return this;
	}

	public String getActive() {
		return this.active;
	}
	public Employee setActive(String active) {
		this.active = active;
		return this;
	}

	public String getRole() {
		return this.role;
	}
	public Employee setRole(String role) {
		this.role = role;
		return this;
	}

	public String getManager() {
		return this.manager;
	}
	public Employee setManager(String manager) {
		this.manager = manager;
		return this;
	}

	public String getPassWord() {
		return this.passWord;
	}
	public Employee setPassWord(String password) {
		this.passWord = password;
		return this;
	}

	public UUID getId() {
		return this.id;
	}
	public Employee setId(UUID id) {
		this.id = id;
		return this;
	}

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public Employee() {
		this.firstName = "";
		this.lastName = "";
		this.employeeID = "";
		this.active = "";
		this.role = "";
		this.manager = "";
		this.passWord = "";
		this.id = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
	}

	public Employee(EmployeeEntity employeeEntity) { //Copy constructor
		this.firstName = employeeEntity.getFirstName();
		this.lastName = employeeEntity.getLastName();
		this.employeeID = employeeEntity.getEmployeeID();
		this.active = employeeEntity.getActive();
		this.role = employeeEntity.getRole();
		this.manager = employeeEntity.getManager();
		this.passWord = employeeEntity.getPassWord();
		this.id = employeeEntity.getId();
		this.createdOn = employeeEntity.getCreatedOn();
	}
}