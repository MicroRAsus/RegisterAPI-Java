package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	private String first_name;
	private String last_name;
	private String employee_id;
	private String active;
	private String role;
	private String manager;
	private String password;

	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.first_name = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.last_name = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.employee_id = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
		this.active = rs.getString(EmployeeFieldNames.ACTIVE);
		this.role = rs.getString(EmployeeFieldNames.ROLE);
		this.manager = rs.getString(EmployeeFieldNames.MANAGER);
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRST_NAME, this.first_name);
		record.put(EmployeeFieldNames.LAST_NAME, this.last_name);
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employee_id);
		record.put(EmployeeFieldNames.ACTIVE, this.active);
		record.put(EmployeeFieldNames.ROLE, this.role);
		record.put(EmployeeFieldNames.MANAGER, this.manager);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		
		return record;
	}

	public String getFirstName() {
		return this.first_name;
	}
	public String getLastName() {
		return this.last_name;
	}
	public String getEmployeeID() {
		return this.employee_id;
	}
	public String getActive() {
		return this.active;
	}
	public String getRole() {
		return this.role;
	}
	public String getManager() {
		return this.manager;
	}
	public String getPassWord() {
		return this.password;
	}
	
	public EmployeeEntity setFirstName(String first_name) {
		if (!StringUtils.equals(this.first_name, first_name)) {
			this.first_name = first_name;
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		}
		
		return this;
	}
	
	public EmployeeEntity setLastName(String last_name) {
		if (!StringUtils.equals(this.last_name, last_name)) {
			this.last_name = last_name;
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		}
		
		return this;
	}
	
	public EmployeeEntity setEmployeeID(String employee_id) {
		if (!StringUtils.equals(this.employee_id, employee_id)) {
			this.employee_id = employee_id;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}
		
		return this;
	}
	
	public EmployeeEntity setActive(String active) {
		if (!StringUtils.equals(this.active, active)) {
			this.active = active;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	public EmployeeEntity setRole(String role) {
		if (!StringUtils.equals(this.role, role)) {
			this.role = role;
			this.propertyChanged(EmployeeFieldNames.ROLE);
		}
		
		return this;
	}
	
	public EmployeeEntity setManager(String manager) {
		if (!StringUtils.equals(this.manager, manager)) {
			this.manager = manager;
			this.propertyChanged(EmployeeFieldNames.MANAGER);
		}
		
		return this;
	}
	
	public EmployeeEntity setPassWord(String password) {
		if (!StringUtils.equals(this.password, password)) {
			this.password = password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}
		
		return this;
	}
	
	public Employee synchronize(Employee apiEmployee) {   //The method name from employee class must be consistent here 
		this.setFirstName(apiEmployee.getFirstName());
		this.setLastName(apiEmployee.getLastName());
		this.setEmployeeID(apiEmployee.getEmployeeID());
		this.setActive(apiEmployee.getActive());
		this.setRole(apiEmployee.getRole());
		this.setManager(apiEmployee.getManager());
		this.setPassWord(apiEmployee.getPassWord());
		
		apiEmployee.setId(this.getId());
		apiEmployee.setCreatedOn(this.getCreatedOn());
		
		return apiEmployee;
	}
	
	public EmployeeEntity() {
		super(DatabaseTable.EMPLOYEE);
		
		this.first_name = StringUtils.EMPTY;
		this.last_name = StringUtils.EMPTY;
		this.employee_id = StringUtils.EMPTY;
		this.active = StringUtils.EMPTY;
		this.role = StringUtils.EMPTY;
		this.manager = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
	}
	
	public EmployeeEntity(Employee apiEmployee) {  //The method name from employee class must be consistent here 
		super(DatabaseTable.EMPLOYEE);
		
		this.first_name = apiEmployee.getFirstName();
		this.last_name = apiEmployee.getLastName();
		this.employee_id = apiEmployee.getEmployeeID();
		this.active = apiEmployee.getActive();
		this.role = apiEmployee.getRole();
		this.manager = apiEmployee.getManager();
		this.password = apiEmployee.getPassWord();
	}
}
