package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private String first_name;
	private String last_name;
	private String employee_id;
	private String active;
	private String role;
	private String manager;
	private String password;
	private UUID id;
	private LocalDateTime createdOn;
	
	public String getFirstName() {
		return this.first_name;
	}
	public Employee setFirstName(String first_name) {
		this.first_name = first_name;
		return this;
	}

	public String getLastName() {
		return this.last_name;
	}
	public Employee setLastName(String last_name) {
		this.last_name = last_name;
		return this;
	}

	public String getEmployeeID() {
		return this.employee_id;
	}
	public Employee setEmployeeID(String employee_id) {
		this.employee_id = employee_id;
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
		return this.password;
	}
	public Employee setPassWord(String password) {
		this.password = password;
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
		this.first_name = "";
		this.last_name = "";
		this.employee_id = "";
		this.active = "";
		this.role = "";
		this.manager = "";
		this.password = "";
		this.id = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
	}

	public Employee(EmployeeEntity employeeEntity) { //Copy constructor
		this.first_name = employeeEntity.getFirstName();
		this.last_name = employeeEntity.getLastName();
		this.employee_id = employeeEntity.getEmployeeID();
		this.active = employeeEntity.getActive();
		this.role = employeeEntity.getRole();
		this.manager = employeeEntity.getManager();
		this.password = employeeEntity.getPassWord();
		this.id = employeeEntity.getId();
		this.createdOn = employeeEntity.getCreatedOn();
	}
}